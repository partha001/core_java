package org.partha.p1GettingTypeInfo;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;

@Log4j2
public class Ex03FindingTypesHandsOn2 {

    public static void main(String[] args) throws ClassNotFoundException {

        printClassInfo(Collection.class
                ,boolean.class
                ,int [][].class
                ,Colors.RED.getClass()
                , new Drawable() {
                    @Override
                    public int getNumberOfCorners() {
                        return 0;
                    }
                }.getClass()
                );

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

            log.info("is array : {}",clazz.isArray());
            log.info("is primitive: {}",clazz.isPrimitive());
            log.info("is enum : {}",clazz.isEnum());
            log.info("is interface : {}",clazz.isInterface());
            log.info("is anonymous : {}",clazz.isAnonymousClass());

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
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- className:Collection  packageName:package java.util
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- class:Collection implements:Iterable
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is array : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is primitive: false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is enum : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is interface : true
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is anonymous : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- className:boolean  packageName:null
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is array : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is primitive: true
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is enum : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is interface : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is anonymous : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- className:int[][]  packageName:null
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- class:int[][] implements:Cloneable
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- class:int[][] implements:Serializable
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is array : true
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is primitive: false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is enum : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is interface : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is anonymous : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- className:Colors  packageName:package org.partha.p1
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is array : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is primitive: false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is enum : true
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is interface : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is anonymous : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- className:  packageName:package org.partha.p1
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- class: implements:Drawable
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is array : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is primitive: false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is enum : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is interface : false
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 -- is anonymous : true
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 18:47:31.369 [main] INFO org.partha.p1.Ex03FindingTypesHandsOn2 --
 */
