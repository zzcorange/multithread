package com.chengzi.multithread.test;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String...args) throws  Exception{
        Thread thread1 = new Thread(()->{

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
            System.out.println(Thread.currentThread().getName()+" before park");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"  park 1");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+"  park 2");
            // LockSupport.unpark(Thread.currentThread());
            // LockSupport.unpark(Thread.currentThread());
            System.out.println(Thread.currentThread().getName()+" after park");
        });
        thread1.start();
        Thread.sleep(2000);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" before park");
            LockSupport.unpark(thread1);
            System.out.println(Thread.currentThread().getName()+" unpark 1");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
            LockSupport.unpark(thread1);
            System.out.println(Thread.currentThread().getName()+" after park");
        }).start();
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+" before park");
//            LockSupport.unpark(thread1);
//
//            System.out.println(Thread.currentThread().getName()+" after park");
//        }).start();
    }
    public void test() throws  Exception{
        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" before park");

            LockSupport.park();
            LockSupport.park();
            // LockSupport.unpark(Thread.currentThread());
            // LockSupport.unpark(Thread.currentThread());
            System.out.println(Thread.currentThread().getName()+" after park");
        });
        thread1.start();
        Thread.sleep(2000);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" before park");
            LockSupport.unpark(thread1);
            LockSupport.unpark(thread1);
            System.out.println(Thread.currentThread().getName()+" after park");
        }).start();
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+" before park");
//            LockSupport.unpark(thread1);
//
//            System.out.println(Thread.currentThread().getName()+" after park");
//        }).start();
    }
}
