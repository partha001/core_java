package org.partha.p2WorkingWithConstructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this program shows how to
 * 1. create object of any class using one single factory method
 * 2. using reflection we will call the right constructor of the class
 * based upon the arguments passed
 */
public class Ex02CreateObjectUsingReflection {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Person person = (Person) createInstanceWithArguments(Person.class);
        System.out.println(person.toString());
        Address address = (Address) createInstanceWithArguments(Address.class,"school road",19);
        System.out.println(address.toString());

    }

    public static Object createInstanceWithArguments(Class<?> clazz, Object... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == args.length) { //doing it in a naive way. actaully parameter type check also needs to be there
                return constructor.newInstance(args);
            }
        }
        System.out.println("an appropriate constructor was not found");
        return null;
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(String.format("clazz %s has %d declared constructors ", clazz.getSimpleName(), constructors.length));

        for (int i = 0; i < constructors.length; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(type -> type.getSimpleName())
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }


    }

    public static class Person {
        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.name = "annonymous";
            this.age = 0;
            this.address = null;
        }

        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
