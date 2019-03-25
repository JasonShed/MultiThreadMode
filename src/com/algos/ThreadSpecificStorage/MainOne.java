package com.algos.ThreadSpecificStorage;

public class MainOne {

    public static void main(String[] args){
        System.out.println("BEGIN");

        for (int i = 0; i < 10; i++) {
            LogOne.println("main: i = " + i);

            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        LogOne.close();
        System.out.println("END");
    }
}
