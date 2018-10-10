package com.chengzi.multithread.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Long> {
    private final int DEFAULT_CAPACITY = 10000;
    private long start;
    private long end;
    public ForkJoinTest(long start,long end){
        this.start= start;
        this.end = end;
    }
    @Override
    protected Long compute(){
        long sum = 0;
        if(end - start <DEFAULT_CAPACITY) {
            for (long i = start; i <= end; i++)
                sum += i;
        }else{
            long middle = (start +end )/2;
            ForkJoinTest forkJoinTest1 = new ForkJoinTest(start,middle);
            ForkJoinTest forkJoinTest2 = new ForkJoinTest(middle+1,end);
            forkJoinTest1.fork();
            forkJoinTest2.fork();
            sum = forkJoinTest1.join()+forkJoinTest2.join();
        }
        return sum;
    }
    public static void main(String...args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        new Thread(()->{
          do{
              System.out.printf("Main: Thread Count: %d\n",forkJoinPool.getActiveThreadCount());
              System.out.printf("Main: Thread Steal: %d\n",forkJoinPool.getStealCount());
              System.out.printf("Main: Parallelism: %d\n",forkJoinPool.getParallelism());
          }while (!forkJoinPool.isShutdown());
        }).start();
        ForkJoinTest forkJoinTest = new ForkJoinTest(1,10000000000L);
        Long forkstartTime = System.currentTimeMillis();
        long result =forkJoinPool.invoke(forkJoinTest);
        System.out.println("结果："+result+";form执行时间："+(System.currentTimeMillis()-forkstartTime));
        result = 0;
        forkstartTime = System.currentTimeMillis();
        for(long l = 0;l<=1000000000;l++){
            result+=l;
        }
        System.out.println("结果："+result+";form执行时间："+(System.currentTimeMillis()-forkstartTime));
    }
}
