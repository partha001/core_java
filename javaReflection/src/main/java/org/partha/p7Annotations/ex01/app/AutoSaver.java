package org.partha.p7Annotations.ex01.app;

import org.partha.p7Annotations.ex01.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex01.app.customAnnotations.InitializerMethod;

/**
 * description: this class can start any background thread to save our applications data to the disk periodically
 */
@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void startAutoSavingThreads(){
        System.out.println("start automatic data saving to disk");
    }
}
