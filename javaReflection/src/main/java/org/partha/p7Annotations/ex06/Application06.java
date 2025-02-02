package org.partha.p7Annotations.ex06;



import org.partha.p7Annotations.ex06.customAnnotations.Annotations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Annotations.ScanPackages(values = {"loaders"})
public class Application06 {

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException {
        schedule();
    }

    public static void schedule() throws URISyntaxException, IOException, ClassNotFoundException {
        Annotations.ScanPackages scanPackages= Application06.class.getAnnotation(Annotations.ScanPackages.class);
        if(scanPackages == null || scanPackages.values().length==0){
            return;
        }

        List<Class<?>> allClasses = getAllClasses(scanPackages.values());
        List<Method> scheduledExecutorMethods = getScheduledExecutorMethods(allClasses);

        for(Method method: scheduledExecutorMethods){
            scheduleMethodExecution(method);
        }
    }


    private static void scheduleMethodExecution(Method method){
        Annotations.ExecuteOnSchedule[] schedules = method.getAnnotationsByType(Annotations.ExecuteOnSchedule.class);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        for(Annotations.ExecuteOnSchedule schedule: schedules){
            scheduledExecutorService.scheduleAtFixedRate(
                    ()-> runWhenScheduled(method),
                    schedule.delaySeconds(),
                    schedule.periodSeconds(),
                    TimeUnit.SECONDS
            );
        }
    }

    private static void runWhenScheduled(Method method){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(String.format("Executing at %s", dateFormat.format(currentDate)));
        try{
            method.invoke(null);
        }catch (IllegalAccessException| InvocationTargetException e){
            e.printStackTrace();
        }
    }

    //discovering the scheduled method
    public static List<Method> getScheduledExecutorMethods(List<Class<?>> allClasses){
        List<Method> scheduledMethods = new ArrayList<>();

        for(Class<?> clazz: allClasses ){
            if(!clazz.isAnnotationPresent(Annotations.ScheduledExecutorClass.class)){
                continue;
            }
            for(Method method: clazz.getDeclaredMethods()){
                if(method.getAnnotationsByType(Annotations.ExecuteOnSchedule.class).length!=0){
                    scheduledMethods.add(method);
                }
            }
        }
        return scheduledMethods;
    }

    //the below two methods are copied from previous examples
    private static List<Class<?>> getAllPackages(Path packagePath, String packageName) throws IOException, ClassNotFoundException {
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
                String classFullName = Application06.class.getPackage().getName() + "." + packageName + "." + fileName.replace(".class", "");

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
            URI packageUri = Application06.class.getResource(packageRelativePath).toURI();

            //now depending upon whether the package is located in a fileSystem or jarFile we have to process it slightly differently
            //as shown below
            if (packageUri.getScheme().equals("file")) { //means its located in a file system
                Path packageFullPath = Paths.get(packageUri);
                allClasses.addAll(getAllPackages(packageFullPath, packageName));
            } else if (packageUri.getScheme().equals("jar")) {

                FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.emptyMap());
                Path packageFullPathInJar = Paths.get(packageUri); //tweaked code
                allClasses.addAll(getAllPackages(packageFullPathInJar, packageName));
                fileSystem.close();
            }
        }
        return allClasses;
    }
}
