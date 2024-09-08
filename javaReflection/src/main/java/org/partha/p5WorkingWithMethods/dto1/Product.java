package org.partha.p5WorkingWithMethods.dto1;

public class Product {
    private double price;
    private String name;
    private long quantity;

    /** attribute without getter. thus if we uncomment the below attribute
     * and then run our Ex01ProductTest class then it will inform us that the
     * getter for the below attribute is not defined **/
    //private String productType;


    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }
}
