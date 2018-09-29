package com.chengzi.multithread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Exmple4 extends Thread{
    public static void main(String args[]) throws  Exception{
        CallableDemoInExmple4 callableDemoInExmple4 = new CallableDemoInExmple4();
        FutureTask futureTask = new FutureTask(callableDemoInExmple4);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
class CallableDemoInExmple4 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("in CallableDemoInExmple4");
        Thread.sleep(10000);
        return "the result of Call";
    }
}
