package com.chengzi.multithread.test.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    static Executor executor = Executors.newSingleThreadExecutor();
    static Executor executor1 = Executors.newCachedThreadPool();
    public static void main(String...agrs){
        for(int i=0;i<10000;i++){
            final int value = i;
            executor1.execute(()->{
                System.out.println(value);
            });
        }
    }
}
