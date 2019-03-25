package com.algos.ThreadSpecificStorage;

public class LogTwo {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String s){
        getTSLog().println(s);
    }

    public static void close(){
        System.out.println("====== End of log =======");
        getTSLog().close();
    }

    private static TSLog getTSLog(){
        TSLog tsLog = tsLogCollection.get();
        if (tsLog == null){
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
