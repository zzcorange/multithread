package com.chengzi.multithread.test.pool;

public class test {

        public static void main(String[] args){
            final String a="Amos ",b="H";
            final String c = a+b;
            final String d = "Amos H";
            String e="Amos ",f="H";
            final String g=e+f;
            System.out.println(c==d);

            System.out.println(c==g);

            System.out.println("c.identityHashCode:"+System.identityHashCode(c));
            System.out.println("g.identityHashCode:"+System.identityHashCode(g));

    }
}
