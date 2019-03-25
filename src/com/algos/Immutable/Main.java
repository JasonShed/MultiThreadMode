package com.algos.Immutable;

public class Main {
    public static void main(String[] args){

        Person alice = new Person("Alice", "USA");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }
}
