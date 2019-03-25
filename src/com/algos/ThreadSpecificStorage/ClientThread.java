package com.algos.ThreadSpecificStorage;

public class ClientThread extends Thread{
    public ClientThread(String name){
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            LogTwo.println("i = " + i);
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LogTwo.close();
        System.out.println(Thread.currentThread().getName() + " END");
    }
}
