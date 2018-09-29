package com.chengzi.multithread.test.pool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
    static ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)cacheThreadPool;

    public static void main(String...args) throws  Exception{

        threadPoolExecutor.setKeepAliveTime(2L,TimeUnit.SECONDS);



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
                final int value = i;
                cacheThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"->"+value);
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
