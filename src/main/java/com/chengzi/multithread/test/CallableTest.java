package com.chengzi.multithread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static Integer common = 1;
    public static Object object;
    public static void main(String...args) throws  Exception{
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Object> futureTask = new FutureTask<>(callableDemo);
        Thread thread = new Thread(futureTask);
        thread.start();
        new Thread(()->{
            synchronized(common){
                System.out.println("before notify");
               try{
                   Thread.sleep(3000);
               }catch (Exception e){

               }

                common.notify();
                System.out.println("after notify");
            }
        }).start();

        try{
          // Object returnvalue =  futureTask.get();
          // System.out.println("返回值"+returnvalue);
        }catch (Exception e){
           e.printStackTrace();
        }
        System.out.println("到底部拉");
    }
}
class CallableDemo implements Callable<Object>{

    @Override
    public Integer call() throws Exception {

      for(int i=0;++i<10000000;) ;
      synchronized(CallableTest.common){
          System.out.println("before synchronized wait");
          CallableTest.common.wait();
          System.out.println("after synchronized wait");
      }
      System.out.println("come to CallableDemo");
        return 20;
    }
}
