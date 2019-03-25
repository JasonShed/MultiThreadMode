package com.algos.ThreadSpecificStorage;

public class MainTwo {
    public static void main(String[] args){
        new ClientThread("Alice").start();
        new ClientThread("Jack").start();
        new ClientThread("Luce").start();
    }
}
