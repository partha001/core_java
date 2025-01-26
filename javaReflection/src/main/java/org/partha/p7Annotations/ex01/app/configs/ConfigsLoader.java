package org.partha.p7Annotations.ex01.app.configs;


import org.partha.p7Annotations.ex01.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex01.app.customAnnotations.InitializerMethod;

@InitializerClass
public class ConfigsLoader {

    @InitializerMethod
    public void loadAllConfigs(){
        System.out.println("loading all configuration files");
    }
}
