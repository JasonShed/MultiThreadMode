package com.algos.SingleThreadExecution;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args){
        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new SemaphoreThread(resource).start();
        }
    }

}

class SemaphoreThread extends Thread{
    private final static Random random = new Random(26535);
    private final BoundedResource boundedResource;
    public SemaphoreThread(BoundedResource boundedResource){
        this.boundedResource = boundedResource;
    }
    public void run(){
        try{
            while (true){
                boundedResource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BoundedResource{
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);
    public BoundedResource(int permits){
        this.permits = permits;
        semaphore = new Semaphore(permits);
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try{
            doUse();
        }finally {
            semaphore.release();
        }
    }

    public void doUse() throws InterruptedException {
        Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used = " + (permits - semaphore.availablePermits()));

    }
}

class Log{
    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}