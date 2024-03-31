package com.partha.multithread.topic05.usingCountdownLatch;

import java.util.concurrent.locks.ReentrantLock;

public class PingPongGameUsingReentrantLock {

    public static void main(String[] args) {

        Game game = new Game("ping");

        Thread t1 = new Thread(() -> game.methodForPlayer1());
        Thread t2 = new Thread(() -> game.methodForPlayer2());
        t1.start();
        t2.start();

    }


    private static class Game {

        ReentrantLock lock = new ReentrantLock();

        volatile String message = "";

        public Game(String message){
            this.message = message;
        }

        public void methodForPlayer1(){
            while(true){
                try{
                    lock.lock();
                    Thread.sleep(1000);
                    message = message.equals("ping") ? "pong" : "ping";
                    System.out.println("threadName:"+ Thread.currentThread().getName() + "  message:"+message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }

        }

        public void methodForPlayer2() {
            while (true) {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    message = message.equals("ping") ? "pong" : "ping";
                    System.out.println("threadName:"+ Thread.currentThread().getName() + "  message:"+message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}



