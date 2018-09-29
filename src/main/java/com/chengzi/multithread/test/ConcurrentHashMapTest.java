package com.chengzi.multithread.test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentHashMapTest {
    public static HashMap<String,Object> hashmap = new HashMap<String,Object>();
    private static CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    public static void main(String...args){

        for(int i = 0 ;i<100;i++){
            new Thread(()->{
                hashmap.put(Thread.currentThread().getName(),new Random().nextInt(100));
            }).start();
        }
        new Thread(()->{
            for(;;){
                if(hashmap.keySet().size()<100)
                    continue;
                int i =0;
                for(String key :hashmap.keySet()){
                    System.out.println(++i+"--"+key+"----"+hashmap.get(key));
                }

                break;
            }
        }).start();
    }
}
