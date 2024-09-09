package org.partha.p5WorkingWithMethods.dto3;

public class Product {
    private double price;
    private String name;
    private long quantity;
    private Address address;

    /** attribute without getter. thus if we uncomment the below attribute
     * and then run our Ex01ProductTest class then it will inform us that the
     * getter for the below attribute is not defined **/
    //private String productType;


    //getters
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
