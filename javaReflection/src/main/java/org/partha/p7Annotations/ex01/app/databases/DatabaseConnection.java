package org.partha.p7Annotations.ex01.app.databases;

import org.partha.p7Annotations.ex01.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex01.app.customAnnotations.InitializerMethod;

@InitializerClass
public class DatabaseConnection {

    @InitializerMethod
    public void connectToDatabase1(){
        System.out.println("connecting to database1");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("connecting to database2");
    }
}