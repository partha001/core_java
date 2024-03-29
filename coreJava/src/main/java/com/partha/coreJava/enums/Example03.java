package com.partha.coreJava.enums;

import java.util.EnumSet;

/**
 * this program is to explore EnumSet
 */
public class Example03 {

    public static void main(String[] args) {
         EnumSet<PizzaStatus> undeliveredPizzaStatuses =
                EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY); //Notice how the enum-set is created and used

        undeliveredPizzaStatuses.stream().forEach( status -> {
            System.out.println("print state:" + status.name() + "   isReadyValue:" + status.isReady() + "    timeToBeDelivered:" + status.timeToDelivery);
        });

    }

    /**
     * here the enum difinitions remains same as the previous example2 class.
     */
    private  enum PizzaStatus {
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
