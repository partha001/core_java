package org.partha.p7Annotations.ex06.loaders;

import org.partha.p7Annotations.ex06.customAnnotations.Annotations;

/**
 * this class is to emulate an in-memory cache. say we want to refresh the cache more number of times
 * on weekdays . however on weekends we want to refresh it lesser number of times. This gives us an idea
 * that its an ideal candidate for repeatable annotations
 *
 * @version 1
 * @author partha
 * @since java21
 */
@Annotations.ScheduledExecutorClass
public class Cache {

    @Annotations.ExecuteOnSchedule(periodSeconds = 5)
    @Annotations.ExecuteOnSchedule(delaySeconds = 10, periodSeconds = 1)
    public static void reloadCache(){
        System.out.println("reloading cache");
    }
}
