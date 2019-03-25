package com.algos.GuardedSuspension;

import java.util.Random;

public class ServerThread extends Thread{
    private final RequestQueue queue;
    private final Random random;

    public ServerThread(RequestQueue queue, String name, long seed) {
        super(name);
        this.queue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
