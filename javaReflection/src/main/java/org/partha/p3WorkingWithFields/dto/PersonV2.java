package org.partha.p3WorkingWithFields.dto;

public class PersonV2 {
    private final String name;
    private final boolean employed;
    private final int age;
    private final float salary;
    private final Address address;

    public PersonV2(String name, boolean employed, int age, float salary,Address address) {
        this.name = name;
        this.employed = employed;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
}
