package com.chengzi.multithread.test;

import java.util.concurrent.FutureTask;

public class TestFuture {
    public static void main(String...args) throws  Exception{
        System.out.println(new FutureTask<Long>(()->{
            return 1l;
        }).get());
    }
}
