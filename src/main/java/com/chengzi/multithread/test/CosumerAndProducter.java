package com.chengzi.multithread.test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class CosumerAndProducter {
    public static AtomicInteger number = new AtomicInteger(0);
    public static final int max = 100;
    public static void main(String...args){
        Consumer consumer = new Consumer();
        Producter producter = new Producter();
        Thread consumerThread = new Thread(consumer);
        Thread producterThread = new Thread(producter);
        consumer.setProducter(producterThread);
        producter.setConsumer(consumerThread);

        consumerThread.start();
        producterThread.start();

    }
}
class Consumer implements  Runnable{
    private Thread producter;
    public void setProducter(Thread producter){
        this.producter = producter;
    }
    @Override
    public void run() {
        Random random = new Random();
        for(;;){
            if(CosumerAndProducter.number.get()<=0){
                System.out.println("没有产品，消费者休眠");
                LockSupport.park();
            }
            int num = random.nextInt(30);
            if(num-CosumerAndProducter.number.get()>0){
                num = CosumerAndProducter.number.get();
                CosumerAndProducter.number.set(0);
            }
            else{
                CosumerAndProducter.number.addAndGet(num*-1);
            }
            System.out.println("消费;数量-"+num+";余额："+CosumerAndProducter.number.get());
            if(CosumerAndProducter.number.get()<=CosumerAndProducter.max){
//                System.out.println("唤醒生产者；");
                LockSupport.unpark(producter);
            }
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Producter implements Runnable{
    private Thread consumer;
    public void setConsumer(Thread consumer){
        this.consumer = consumer;
    }
    @Override
    public void run(){
        Random random = new Random();
        for(;;){
            if(CosumerAndProducter.number.get()>=CosumerAndProducter.max){
                System.out.println("超过上限。生产者休眠");
                LockSupport.park();
            }
            int num = random.nextInt(30);
            if(num+CosumerAndProducter.number.get()<100)
            CosumerAndProducter.number.addAndGet(num);
            else{
                num = 100-CosumerAndProducter.number.get();
                CosumerAndProducter.number.set(100);
            }
            System.out.println("生产;数量+"+num+";余额："+CosumerAndProducter.number.get());
            if(CosumerAndProducter.number.get()>=1){
//                System.out.println("唤醒消费者；");
                LockSupport.unpark(consumer);
            }
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
