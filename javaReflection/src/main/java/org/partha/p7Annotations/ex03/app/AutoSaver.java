package org.partha.p7Annotations.ex03.app;

import org.partha.p7Annotations.ex03.app.customAnnotations.InitializerClass;
import org.partha.p7Annotations.ex03.app.customAnnotations.InitializerMethod;

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
