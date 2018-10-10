package com.chengzi.multithread.test;

import java.util.concurrent.locks.LockSupport;

public class WaitTest {
    public static volatile String temp = "";
    public static void main(String...args) throws  Exception{
         new Thread(()->{
            System.out.println("com to thread->"+Thread.currentThread().getName());
            synchronized (temp){
                System.out.println(Thread.currentThread().getName()+" get the lock of temp");
               try {
                   Thread.sleep(10000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+" 释放锁");
                LockSupport.park(temp);
            }
        }).start();
        new Thread(()->{
            System.out.println("com to thread->"+Thread.currentThread().getName());
            synchronized (temp){
                System.out.println(Thread.currentThread().getName()+" get the lock of temp");
                try {
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 释放锁");
                temp.notify();
            }
        }).start();
    }
}
