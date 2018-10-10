package com.chengzi.multithread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String...args) throws  Exception{
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println("come to FutureTask");
            Thread.sleep(5000);
            System.out.println("leave FutureTask");
            return 1;
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);

        System.out.println("before the get");
        System.out.println("the answer:"+futureTask.get());
    }
}
