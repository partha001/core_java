package org.partha.p7Annotations.ex03.app.databases;

import org.partha.p7Annotations.ex03.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex03.app.customAnnotations.InitializerMethod;
import org.partha.p7Annotations.ex03.app.customAnnotations.RetryOperation;

import java.io.IOException;

@InitializerClass
public class DatabaseConnection {

    private int failCounter = 5;

    @RetryOperation(
            numberOfRetries = 10,
            retryException = IOException.class,
            durationBetweenRetriesMs = 1000,
            failureMessage = "connection to database1 failed after retries"
    )
    @InitializerMethod
    public void connectToDatabase1() throws IOException {
        System.out.println("connecting to database1");
        if (failCounter>0) { // adding logic to fail the method during the first 5 attemps
            failCounter--;
            throw new IOException("connection failed");
        }
        System.out.println("connection to the database1 succeded");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("connecting to database2");
    }
}