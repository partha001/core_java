package com.partha.coreJava.enums;

/**
 * this program is to explore the basics of enum
 */
public class Example01 {

    public static void main(String[] args) {
        //usecase1 : making use of an enum
        Level myVar = Level.MEDIUM;
        System.out.println(myVar);

        //usecase2: making use of enum in switch-case
        switch(myVar) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
    }


    /**
     * simple enum declaration
     */
    enum Level {
        LOW,
        MEDIUM,
        HIGH;
    }



}

