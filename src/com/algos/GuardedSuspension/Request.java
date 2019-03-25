package com.algos.GuardedSuspension;

public class Request {
    private final String name;
    public Request(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" + "name='" + name + "\'" + "}";
    }

    public String getName() {
        return name;
    }
}
