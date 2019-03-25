package com.algos.GuardedSuspension;

import java.util.Random;

public class ClientThread extends Thread{
    private final RequestQueue queue;
    private final Random random;

    public ClientThread(RequestQueue queue, String name, long seed) {
        super(name);
        this.queue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + "request:" + request);
            queue.putRequest(request);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
