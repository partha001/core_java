package org.partha.p1GettingTypeInfo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.partha.p1GettingTypeInfo.dto.Employee;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * this program show the different ways to get hold of the type of an
 * entity in java at runtime.
 */
@Log4j2
public class Ex01WaysToObtainClassObject {


    public static void main(String[] args) {

        /******************************************************
         *  first way of getting the class-type object of
         * any given object is by using the getClass() method of the object
         * **/
        Class<?> var1 = "partha".getClass();
        log.info(var1); //class java.lang.String

        log.info(new Employee(1, "partha").getClass()); //class org.partha.p1.dto.Employee

        log.info(new Human(7, 70).getClass()); //class org.partha.p1.Ex01WaysToObtainClassObject$Human

        Map<String, Integer> map = new HashMap<String, Integer>();
        log.info(map.getClass()); //class java.util.HashMap
        //note that in the above case it returns Hshmap i.e the actual concrete class and not the java.util.Map interface

        log.info(Days.MONDAY.getClass());
        /** also note that since we are calling the .getClass() on a given object
         * hence it can be used on primitive datatype **/


        /*************************************************************
         * the second way is by appending the .class to name of the type.
         * note that this method can be used along with names of interface
         */
        Class<?> var4 = String.class;
        log.info(var4); //class java.lang.String
        log.info(Employee.class);//class org.partha.p1.dto.Employee
        log.info(Human.class);//org.partha.p1.Ex01WaysToObtainClassObject$Human
        log.info(HashMap.class);//class java.util.HashMap
        log.info(Serializable.class); //interface java.io.Serializable
        log.info(Double.class);//class java.lang.Double


        /**
         * the thrid way is by using the Class.forName() method. using this
         * we can find the type of any class dynamically by passing fully-qualified-name
         * name of any class present in our classpath , as shown below
         */
        try {
            Class<?> var5 = Class.forName("java.lang.String");
            log.info(var5); //class java.lang.String

            log.info(Class.forName("org.partha.p1GettingTypeInfo.dto.Employee"));//class org.partha.p1.dto.Employee

            log.info(Class.forName("java.io.Serializable")); //interface java.io.Serializable

            //for inner classes we have to use a $ signbetween parent and child class
            log.info(Class.forName("org.partha.p1GettingTypeInfo.Ex01WaysToObtainClassObject$Human")); //class org.partha.p1.Ex01WaysToObtainClassObject$Human


            // the below will not give any compilation error but wil throw runtime exception
            //log.info(Class.forName("int")); //java.lang.ClassNotFoundException: int
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @NoArgsConstructor
    @AllArgsConstructor
    static class Human {

        int height;
        int weight;
    }

    enum Days {
        MONDAY,
        TUESDAY
    }

}
