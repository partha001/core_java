package com.partha.coreJava.enums;

/**
 * this is to explore fields, methods and constructors in enum
 */
public class Example02 {

    public static void main(String[] args) {
        PizzaStatus status = PizzaStatus.READY;
        System.out.println("print state:" + status.name() + "   isReadyValue:" + status.isReady() + "    timeToBeDelivered:" + status.timeToDelivery);

    }

    public enum PizzaStatus {
        ORDERED(5) { //here the constructor is being called

            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        // here is the attribute declaration. and all enum objects get this attribute
        private int timeToDelivery;


        //here is the constructor declaration. this is called from each enum with static parameter declaration
        PizzaStatus(int timeToDelivery) {   //node that here is the constructor
            this.timeToDelivery = timeToDelivery;
        }


        //here below are the method declaration with default behavior which is being overridden inside every enum
        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }


    }

}
