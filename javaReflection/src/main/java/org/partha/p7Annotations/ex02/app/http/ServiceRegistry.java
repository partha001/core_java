package org.partha.p7Annotations.ex02.app.http;

import org.partha.p7Annotations.ex02.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex02.app.customAnnotations.InitializerMethod;

@InitializerClass
public class ServiceRegistry {


    @InitializerMethod
    public void registerService(){
        System.out.println("service successfully registered");
    }


}
