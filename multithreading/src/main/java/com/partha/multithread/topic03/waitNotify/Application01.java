package com.partha.multithread.topic03.waitNotify;

import java.util.stream.IntStream;

public class Application01 {

    public static void main(String[] args) {

        SharedResource sr = new Application01.SharedResource();

        Thread t1 = new Thread(() -> {
            sr.performTask1();
        });


        Thread t2 = new Thread(() -> {
            sr.performTask2();
        });


        t1.start();
        t2.start();

    }


    private static class SharedResource {

        private volatile int counter = 1;

        public synchronized void performTask1() {
            IntStream.range(0, 1).forEach(i -> {
                try {
                    System.out.println("task1 invoked theadName:" + Thread.currentThread().getName());
                    wait();
                    System.out.println("task1 resumed theadName:" + Thread.currentThread().getName());
                    Thread.sleep(5000L);
                    System.out.println("task1 completed");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }


        public synchronized void performTask2() {
            IntStream.range(0, 1).forEach(i -> {
                try {
                    System.out.println("task2 invoked theadName:" + Thread.currentThread().getName());
                    Thread.sleep(5000L);
                    System.out.println("task2 complted. calling notify() now");
                    notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}






