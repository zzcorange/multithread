package com.chengzi.multithread.test.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPool{
    static ScheduledExecutorService ScheduledExecutorService = Executors.newScheduledThreadPool(10);
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String...args){
        for(int i=0;i<100;i++)
            ScheduledExecutorService.schedule(()->{

            },20,TimeUnit.SECONDS);
    }
}
