package com.chengzi.multithread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

public class MultithreadApplicationTests {

    @Test
    public void contextLoads() {
        Random random = new Random(1000);
        random.setSeed(1000);
        for(int i = 0;i<100;i++)
        System.out.print(random.nextInt(1000)+" ");
        System.out.println();
        random.setSeed(1000);
        for(int i = 0;i<100;i++)
            System.out.print(random.nextInt(1000)+" ");
        System.out.println();
        random.setSeed(1000);
        for(int i = 0;i<100;i++)
            System.out.print(random.nextInt(1000)+" ");

    }
    @Test
    public void testSeed(){
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            random.setSeed(100);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println("");
        }
    }

}
