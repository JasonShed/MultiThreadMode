package com.algos.SingleThreadExecution;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    public synchronized void pass(String name, String address){
        counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public synchronized String toString(){
        return "NO." + counter + ": " + name + ", " + address;
    }

    private void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("****** BROKEN *****  " + toString());
        }
    }
}
