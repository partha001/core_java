package org.partha.p8DynamicProxies.ex01;

import org.partha.p8DynamicProxies.ex01.external.DatabaseReader;
import org.partha.p8DynamicProxies.ex01.external.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * this is same as Application02 . this is just to that the concept of dynamic proxy is so powerful
 * that it can even be used on native jdk classes like arraylist.
 *
 * however the duration of addition and removal of elements from arraylist is so small and even in milliseconds it would come as 0.
 * so we have made another small change i.e. we have replaced System.currentTimeMillis() with System.nanoTime()
 */
public class Application03 {

    public static void main(String[] args) throws InterruptedException {
        List<String> listOfGreetings = createProxy(new ArrayList<>());
        listOfGreetings.add("hello");
        listOfGreetings.add("good morning");
        listOfGreetings.remove("hello");
    }

    public static void useHttpClient(HttpClient httpClient) {
        httpClient.initialize();
        String response = httpClient.sendRequest("some request");
        System.out.println(String.format("http response is : %s", response));
    }

    public static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException {
        int rowsInGamesTable = databaseReader.countRowsInTable("GameTable");
        System.out.println(String.format("there are %s rows in GameTable", rowsInGamesTable));
        String[] data = databaseReader.readRow("select * from GamesTable");
        System.out.println(String.format("Received %s", String.join(",", data)));
    }


    public static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();
        TimeMeasuringProxyHandler timeMeasuringProxyHandler = new TimeMeasuringProxyHandler(originalObject);
        return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
    }


    public static class TimeMeasuringProxyHandler implements InvocationHandler {

        private final Object originalObject;

        public TimeMeasuringProxyHandler(Object originalObject) {
            this.originalObject = originalObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;

            System.out.println(String.format("measuring proxy - before executing method : %s()", method.getName()));

            //long startTime = System.currentTimeMillis();
            //result = method.invoke(originalObject, args);
            //long endTime = System.currentTimeMillis();

            long startTime = System.nanoTime();
            result = method.invoke(originalObject, args);
            long endTime = System.nanoTime();

            System.out.println();
            System.out.println(String.format("measuring proxy - execution of %s() too %dns \n", method.getName(), endTime - startTime));

            return result;
        }
    }
}
