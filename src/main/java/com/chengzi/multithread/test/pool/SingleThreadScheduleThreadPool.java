package com.chengzi.multithread.test.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingleThreadScheduleThreadPool {
    static Executor executor = Executors.newSingleThreadScheduledExecutor();
    public static volatile int a = 0;
    public static void main(String...args){
        for(int i=0;i<10000;i++){
            executor.execute(()->{
                System.out.print(a+++" ");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
    }
}
