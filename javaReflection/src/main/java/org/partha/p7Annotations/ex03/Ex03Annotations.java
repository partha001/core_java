package org.partha.p7Annotations.ex03;

import lombok.extern.log4j.Log4j2;
import org.partha.p7Annotations.ex03.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex03.app.customAnnotations.InitializerMethod;
import org.partha.p7Annotations.ex03.app.customAnnotations.RetryOperation;
import org.partha.p7Annotations.ex03.app.customAnnotations.ScanPackages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * programDescription: this example is to furthur enhance the previous program. here we want to add some retry logic using annotation
 *                      for anything that fails during our program initialization. say for example: the database initializer
 *                      fails the initialize the connection in the first attemp then we
 */
@Log4j2
@ScanPackages(values = {"app", "app.configs", "app.databases", "app.http"})
public class Ex03Annotations {

    public static void main(String[] args) throws Throwable {
        log.info("program execution started");

        //Class.forName("org.partha.p7Annotations.ex01.app.AutoSaver");
        //System.out.println("class loaded successfully");

        //initialize("app");
        //initialize("app", "app.configs", "app.databases", "app.http");

        initialize();

        log.info("program execution completed");
    }

    public static void initialize() throws Throwable {

        ScanPackages scanPackages = Ex03Annotations.class.getAnnotation(ScanPackages.class);

        if(scanPackages == null || scanPackages.values().length==0){
            return;
        }

        //List<Class<?>> classes = getAllClasses(packageNames);
        List<Class<?>> classes = getAllClasses(scanPackages.values());


        for (Class<?> clazz : classes) {
            if (!clazz.isAnnotationPresent(InitializerClass.class)) {
                continue;
            }

            List<Method> methods = getAllInitializingMethods(clazz);
            Object instance = clazz.getDeclaredConstructor().newInstance(); //assuming that there is a zero parameter constructor
            for (Method method : methods) {
                //method.invoke(instance); // thus executing the method to perform the initialization logic

                callInitializingMethod(instance, method);
            }
        }
    }

    private static void callInitializingMethod(Object instance,Method method) throws Throwable {
        RetryOperation retryOperation = method.getAnnotation(RetryOperation.class);
        int numberOfRetries = retryOperation == null? 0: retryOperation.numberOfRetries();
        while(true){
            try{
                method.invoke(instance);
                break;
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if(numberOfRetries>0 && Set.of(retryOperation.retryException()).contains(targetException.getClass())){
                    numberOfRetries--;
                    System.out.println("Retrying...");
                    Thread.sleep(retryOperation.durationBetweenRetriesMs());
                } else if(retryOperation!=null){
                    throw new Exception(retryOperation.failureMessage(), targetException);
                }
            }
        }

    }

    public static List<Method> getAllInitializingMethods(Class<?> clazz) {
        List<Method> initializingMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(InitializerMethod.class)) {
                initializingMethods.add(method);
            }
        }
        return initializingMethods;
    }

    private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName) throws IOException, ClassNotFoundException {
        if (!Files.exists(packagePath)) {
            return Collections.emptyList();
        }

        List<Path> files = Files.list(packagePath)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        List<Class<?>> classes = new ArrayList<>();

        for (Path filePath : files) {
            String fileName = filePath.getFileName().toString();
            if (fileName.endsWith(".class")) {

                //sourceCode from tutorial
                //String classFullName = packageName + "." + fileName.replace(".class", "");

                //code changed as per my need. since my main class is located not under src/main/java but is further nested
                String classFullName = Ex03Annotations.class.getPackage().getName() + "." + packageName + "." + fileName.replace(".class", "");

                Class<?> clazz = Class.forName(classFullName);
                classes.add(clazz);
            }
        }
        return classes;
    }

    public static List<Class<?>> getAllClasses(String... packageNames) throws URISyntaxException, IOException, ClassNotFoundException {
        List<Class<?>> allClasses = new ArrayList<>();


        for (String packageName : packageNames) {
            String packageRelativePath = packageName.replace(".", "/");
            URI packageUri = Ex03Annotations.class.getResource(packageRelativePath).toURI();

            //now depending upon whether the package is located in a fileSystem or jarFile we have to process it slightly differently
            //as shown below
            if (packageUri.getScheme().equals("file")) { //means its located in a file system
                Path packageFullPath = Paths.get(packageUri);
                allClasses.addAll(getAllPackageClasses(packageFullPath, packageName));
            } else if (packageUri.getScheme().equals("jar")) {

//                //code as per source. however this was not working for me .
//                FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.emptyMap());
//                Path packageFullPathInJar = fileSystem.getPath(packageRelativePath); //code from tutorial
//                allClasses.addAll(getAllPackageClasses(packageFullPathInJar, packageName));
//                fileSystem.close();

                //having the same code as for file system worked for jar file for me.
                FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.emptyMap());
                Path packageFullPathInJar = Paths.get(packageUri); //tweaked code
                allClasses.addAll(getAllPackageClasses(packageFullPathInJar, packageName));
                fileSystem.close();
            }
        }
        return allClasses;
    }
}
