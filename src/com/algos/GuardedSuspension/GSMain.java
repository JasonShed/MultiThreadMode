package com.algos.GuardedSuspension;

public class GSMain {
    public static void main(String[] args){
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Client Thread", 10000L).start();
        new ServerThread(requestQueue, "Server Thread", 20000L).start();
    }
}