package com.chengzi.multithread.test.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FixThreadPool {
    static Executor executor = Executors.newFixedThreadPool(10);
    public static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String...args){
        for(int i=0;i<20;i++)
            executor.execute(()->{
                System.out.println(atomicInteger.getAndAdd(1));
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();;
                }
            });
    }
}
