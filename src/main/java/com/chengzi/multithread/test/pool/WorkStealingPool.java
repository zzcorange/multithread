package com.chengzi.multithread.test.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkStealingPool {
    static Executor executor  = Executors.newWorkStealingPool();
    public static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String...args){
        for(int i=0;i<10000;i++){
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"->"+atomicInteger.getAndAdd(1));
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
        for(;;);
    }
}
