package com.chengzi.multithread.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 斐波那契数列
 */
public class Fib {
    public static void main(String...args) throws Exception{
        Long time = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
      //  Future result =  forkJoinPool.submit(new FibTask(70L));
      //  System.out.println("计算结果："+result.get()+";耗时："+(System.currentTimeMillis()-time));
//        time = System.currentTimeMillis();
//        System.out.println("计算结果："+fib(35L)+";耗时："+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        System.out.println("计算结果："+fibFor(1000L)+";耗时："+(System.currentTimeMillis()-time));
    }
    public static long fib(long l){
        return l==0l||l==1l?l:(fib(l-1)+fib(l-2));
    }
    public static long fibFor(long l){
        Map<Long,Long> map = new HashMap<Long,Long>();
        map.put(0l,0l);
        map.put(1l,1l);
        for(long temp =2;temp<=l;temp ++){
            map.put(temp,map.get(temp-1)+map.get(temp-2));
        }
        return map.get(l);
    }
}
class FibTask extends RecursiveTask<Long> {
    private long ThreadHold = 35;
    private long number;
    public FibTask(Long number){
        this.number= number;
    }
    @Override
    protected Long compute() {
        if(number<=this.ThreadHold){
            return Fib.fib(number);
        }
        FibTask fibTask1 = new FibTask(number-1);
        FibTask fibTask2 = new FibTask(number-2);
        fibTask1.fork();
        fibTask2.fork();
        return fibTask1.join()+fibTask2.join();
    }
}

