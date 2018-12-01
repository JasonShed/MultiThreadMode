package com.algos.SingleThreadExecution;

public class Main {
    public static void main(String[] args){
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bob", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();

    }
}
