package org.partha.p1GettingTypeInfo;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class Ex02FindingTypesHandsOn {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String,Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();

        Class<?> circle = Class.forName("org.partha.p1GettingTypeInfo.Ex02FindingTypesHandsOn$Circle");

        printClassInfo(stringClass, hashMapClass, circle);

    }

    private static void printClassInfo(Class<?> ... classes){

        for(Class<?> clazz : classes){
            log.info("className:{}  packageName:{}",
                    clazz.getSimpleName(),
                    clazz.getPackage());

            Class<?>[] implementedInterfaces = clazz.getInterfaces();
            for(Class<?> implementedInterface: implementedInterfaces){
                log.info("class:{} implements:{}",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName());
            }

            log.info("");
            log.info("");
        }
    }



    private static interface Drawable {
        int getNumberOfCorners();
    }

    private static class Circle implements  Drawable{

        @Override
        public int getNumberOfCorners() {
            return 0;
        }
    }

    private enum Colors {
        RED,
        BLUE,
        GREEN,
        YELLOW
    }
}

/**
 * program output:
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- className:String  packageName:package java.lang
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:String implements:Serializable
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:String implements:Comparable
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:String implements:CharSequence
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:String implements:Constable
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:String implements:ConstantDesc
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn --
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn --
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- className:HashMap  packageName:package java.util
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:HashMap implements:Map
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:HashMap implements:Cloneable
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:HashMap implements:Serializable
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn --
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn --
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- className:Circle  packageName:package org.partha.p1
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn -- class:Circle implements:Drawable
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn --
 18:47:02.431 [main] INFO org.partha.p1.Ex02FindingTypesHandsOn --
 */
