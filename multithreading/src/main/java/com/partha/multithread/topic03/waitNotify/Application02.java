package com.partha.multithread.topic03.waitNotify;

public class Application02 {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game("ping");

        Thread player1 = new Thread(() -> {
            game.performTask1();
        });
        player1.start();

        Thread player2 = new Thread(() -> {
            game.performTask2();
        });
        player2.start();


    }


    private static class Game {

        private volatile String game = "";

        public Game(String game) {
            this.game = game;
        }

        public synchronized void performTask1() {   //this method is called by thread1/player1
            try {
                while(true) {
                    Thread.sleep(1000); //note that have introduced the delay from 1.
                    wait();
                    game = game.equals("ping") ? "pong" : "ping";
                    System.out.println("threadName:" + Thread.currentThread().getName() + " output:" + game);
                    notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        /**  also note that the wait and notify are in reverse order **/

        public synchronized void performTask2() { //this method is called by thread2/player2
            try {
                while(true) {
                    notify();
                    game = game.equals("ping") ? "pong" : "ping";
                    System.out.println("threadName:" + Thread.currentThread().getName() + " output:" + game);
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}






