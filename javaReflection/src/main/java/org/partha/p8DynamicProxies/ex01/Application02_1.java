package org.partha.p8DynamicProxies.ex01;

import org.partha.p8DynamicProxies.ex01.external.DatabaseReader;
import org.partha.p8DynamicProxies.ex01.external.HttpClient;
import org.partha.p8DynamicProxies.ex01.external.impl.DatabaseReaderImpl;
import org.partha.p8DynamicProxies.ex01.external.impl.HttpClientImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * this program contains changes on top of the previous program . note: how the warning in line-44 has been handled.
 * i.e. first we return the object itself not returning it as generic
 * secondly at the receiving end of the object we cast it to the appropriate type.
 */
public class Application02_1 {

    public static void main(String[] args) throws InterruptedException {

//        HttpClient httpClient = new HttpClientImpl();
//        DatabaseReader databaseReader = new DatabaseReaderImpl();
        HttpClient httpClient = (HttpClient) createProxy(new HttpClientImpl());
        DatabaseReader databaseReader = (DatabaseReader) createProxy(new DatabaseReaderImpl());
        useHttpClient(httpClient);
        useDatabaseReader(databaseReader);
    }

    public static void useHttpClient(HttpClient httpClient){
        httpClient.initialize();
        String response = httpClient.sendRequest("some request");
        System.out.println(String.format("http response is : %s", response));
    }

    public static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException {
        int rowsInGamesTable = databaseReader.countRowsInTable("GameTable");
        System.out.println(String.format("there are %s rows in GameTable", rowsInGamesTable));
        String[] data = databaseReader.readRow("select * from GamesTable");
        System.out.println(String.format("Received %s", String.join(",",data)));
    }


    public static  Object createProxy(Object originalObject){
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();
        TimeMeasuringProxyHandler timeMeasuringProxyHandler = new TimeMeasuringProxyHandler(originalObject);
        //return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
        return Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
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

            long startTime = System.currentTimeMillis();
            result = method.invoke(originalObject, args);
            long endTime = System.currentTimeMillis();

            System.out.println();
            System.out.println(String.format("measuring proxy - execution of %s() too %dms \n", method.getName(), endTime-startTime));

            return result;
        }
    }
}
