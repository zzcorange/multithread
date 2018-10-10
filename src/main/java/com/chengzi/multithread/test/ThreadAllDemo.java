package com.chengzi.multithread.test;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadAllDemo {
    public static void main(String...args) throws ExecutionException, InterruptedException {
        FutureTask future = new FutureTask(()->{
            System.out.println("come to futureTask;"+Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 1;
        });
        new Thread(future).start();
        System.out.println("等待定时任务执行结果："+new Date());
        System.out.println("定时任务返回："+ future.get()+"；时间："+new Date());

    }
}
