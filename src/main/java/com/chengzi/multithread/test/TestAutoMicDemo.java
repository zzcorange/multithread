package com.chengzi.multithread.test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAutoMicDemo {
    public static void main(String...args){
       AutoMicDemoRunable autoMicDemoRunable = new AutoMicDemoRunable();
      AutoMicDemo autoMicDemo =   new AutoMicDemo();
        for(int i=0; i < 10; i++)
            new Thread(autoMicDemoRunable).start();
    }
}
class AutoMicDemo extends  Thread{
    private volatile int serialNumber = 0;
    @Override
    public void run(){
        System.out.println(serialNumber++);
    }

}
class AutoMicDemoRunable implements  Runnable{
    private AtomicInteger serialNumber = new AtomicInteger();
    public void run(){
        try{
            Thread.sleep(200);
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());

    }
    public int getSerialNumber(){
        return serialNumber.getAndAdd(1);
    }
}