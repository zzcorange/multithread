package com.chengzi.multithread.test;

public class TestJoin {
    public static Thread  thread= new Thread(()->{
        System.out.println("2 begin");
        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
        System.out.println("2 end");
    });
    public static void main(String...args){
        thread.start();;
        new Thread(()->{
            System.out.println("1 begin");
            try{
                thread.join();
            }catch (InterruptedException e){

            }
            System.out.println("1 end");
        }).start();
    }
}
