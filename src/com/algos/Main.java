package com.algos;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("hello")).start();
    }
}

class Printer implements Runnable{
    private String message;
    public Printer(String message){
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(message);
    }
}

