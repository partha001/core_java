package org.partha.p8DynamicProxies.ex02;

import org.partha.p8DynamicProxies.ex02.external.DatabaseReader;
import org.partha.p8DynamicProxies.ex02.external.HttpClient;
import org.partha.p8DynamicProxies.ex02.external.impl.DatabaseReaderImpl;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * this class in an extention to the previous program. here we see how to do exception handling so that our dynamic proxy class
 * behaves exactly at the original class even in case of exception
 *
 * note the change line-73 try-catch
 */
public class Application04_1 {

    public static void main(String[] args) throws InterruptedException {


//        DatabaseReader databaseReader = new DatabaseReaderImpl();
//        useDatabaseReader(databaseReader);


        DatabaseReader databaseReader = createProxy(new DatabaseReaderImpl());
        useDatabaseReader(databaseReader);
    }

    public static void useHttpClient(HttpClient httpClient){
        httpClient.initialize();
        String response = httpClient.sendRequest("some request");
        System.out.println(String.format("http response is : %s", response));
    }

    public static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException {
        int rowsInGamesTable = 0;
        try {
            rowsInGamesTable = databaseReader.countRowsInTable("GameTable");
        } catch (IOException e) {
            System.out.println("catching exceptin "+ e);
            return;
        }
        System.out.println(String.format("there are %s rows in GameTable", rowsInGamesTable));
        String[] data = databaseReader.readRow("select * from GamesTable");
        System.out.println(String.format("Received %s", String.join(",",data)));
    }


    @SuppressWarnings("unchecked")
    public static<T> T createProxy(Object originalObject){
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

            long startTime = System.currentTimeMillis();
            try {
                result = method.invoke(originalObject, args);
            } catch(InvocationTargetException e){
                throw e.getTargetException();
            }
            long endTime = System.currentTimeMillis();

            System.out.println();
            System.out.println(String.format("measuring proxy - execution of %s() too %dms \n", method.getName(), endTime-startTime));

            return result;
        }
    }
}
