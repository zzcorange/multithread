package com.chengzi.multithread.test;

public class TestVolatile {
    public static void  main(String...args){
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        while (true)
        {
            if(threadDemo.getFlag())
            {
                System.out.println("break the while");
                break;
            }
        }

    }

}
class ThreadDemo implements  Runnable{
    private volatile boolean flag = false;

    public void run(){
        try{
            Thread.sleep(200);
        }catch (Exception e){

        }
        flag = true;
        System.out.println("change the flag->"+flag);
    }
    public boolean getFlag(){
        return flag;
    }
}