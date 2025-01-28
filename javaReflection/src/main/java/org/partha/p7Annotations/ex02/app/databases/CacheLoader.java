package org.partha.p7Annotations.ex02.app.databases;


import org.partha.p7Annotations.ex02.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex02.app.customAnnotations.InitializerMethod;

@InitializerClass
public class CacheLoader {


    @InitializerMethod
    public void loadCache(){
        System.out.println("loading data from cache");
    }

    public void reloadCache(){
        System.out.println("reload cache");
    }
}
