package com.chengzi.multithread.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolTest {
    static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
    static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)cacheThreadPool;
    @Test
    public void cacheThreadPoolTest(){

        threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.SECONDS);

        new Thread(()->{
            for(;;){
                System.out.println("活跃线程数："+threadPoolExecutor.getActiveCount());
                System.out.println("线程池大小："+threadPoolExecutor.getPoolSize());
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException i){
                    i.printStackTrace();;
                }
            }
        }).start();

        new Thread(()->{
            int i =0;
            for(;;){
                cacheThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(20000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                });
                if(++i>5000) break;;
//                try {
//                    Thread.sleep(500);
//                }catch (InterruptedException i){
//
//                }
            }
        }).start();


    }
}
