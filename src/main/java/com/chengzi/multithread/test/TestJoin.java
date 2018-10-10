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
       new Thread(()->{
           System.out.println("come to Thread outer");
           Thread thread =  new Thread(()->{
                System.out.println("come to Thread inner");
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("leave Thread inner");
           });
           thread.start();
           new Thread(()->{
               try{
                   Thread.sleep(2000);
               }catch (InterruptedException e){

               }
               System.out.println("终止内部启动线程的执行");
               thread.interrupt();
           }).start();
            try{
                thread.join();
            }catch (InterruptedException e){

            }
           System.out.println("leave Thread outer");
       }).start();
    }
}
