package org.partha.p3WorkingWithFields;

import java.lang.reflect.Field;

public class Program1WorkingWithFields {

    public static void main(String[] args) {
        printDeclaredFieldsInfo(Movie.class);

    }

    public static void printDeclaredFieldsInfo(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(String.format("field name: %s type : %s",
                    field.getName(),
                    field.getType().getName()));
            System.out.println();
        }
    }

    //superclass
    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }


    //childClass
    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private Category category;
        private double actualPrice;


        public Movie(String name, int year, double price, boolean isReleased, Category category) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = Math.max(price, MINIMUM_PRICE);
        }

    }


    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }
}
