package com.chengzi.multithread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class aa {
    public static void test(Object...o){
    }
    public static void main(String...args) throws Exception{
        Callable<Long> callable = ()->{
            return 1l;
        };
        FutureTask<Long> futureTask = new FutureTask<Long>(()->{
            return 1l;
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
