package com.algos.Immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {
    public static void main(String[] args){
        //ArrayList
        List<Integer> list1 = new ArrayList<>();
        new WriterThread(list1).start();
        new ReaderThread(list1).start();

        //Collections.synchronizedList()
        List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
        new WriterThread(list2).start();
        new ReaderThread(list2).start();

        //CopyOnWriteArrayList
        List<Integer> list3 = new CopyOnWriteArrayList<>();
        new WriterThread(list3).start();
        new ReaderThread(list3).start();

    }
}

class WriterThread extends Thread{
    private final List<Integer> list;
    public WriterThread(List<Integer> list){
        super("WriterThread");
        this.list = list;
    }
    @Override
    public void run() {
        for (int i = 0; true; i++) {
            list.add(i);
            list.remove(0);
        }
    }
}

class ReaderThread extends Thread{
    private final List<Integer> list;
    public ReaderThread(List<Integer> list){
        super("ReaderThread");
        this.list = list;
    }

    @Override
    public void run() {
        while (true)
        for (int i:list) {
            System.out.println(i);
        }
    }
}