package org.partha.p7Annotations.ex06.customAnnotations;

import java.lang.annotation.*;

public class Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface ScanPackages {
        String[] values();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface ScheduledExecutorClass{ //this annotation is to mark the class
    }

    @Repeatable(ExecutionSchedules.class)
    @Target(ElementType.METHOD)
    public @interface ExecuteOnSchedule{ //this is the base repeatable annotation for the method which is to be repeated
        int delaySeconds() default 0;
        int periodSeconds();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExecutionSchedules{ //this is the container annotation
        ExecuteOnSchedule[] value();
    }

}
