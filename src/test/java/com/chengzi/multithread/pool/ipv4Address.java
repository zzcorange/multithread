package com.chengzi.multithread.pool;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Pattern;

public class ipv4Address {
    public static void main(String...args){
        String address = "127.0.0.1";
        String reg = "(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d|(25[0-5])))\\s*\\.\\s*(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d|(25[0-5])))\\s*\\.\\s*(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d|(25[0-5])))\\s*\\.\\s*(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d|(25[0-5])))";
       if(!address.matches(reg)){
           System.out.println("格式不正确");
           return;
       }
       String[] datas = address.replaceAll("\\s","").split("\\.");
       long sum = Long.valueOf(datas[0])<<24+ Long.valueOf(datas[1])<<16+ Long.valueOf(datas[2])<<8+ Long.valueOf(datas[3]);
        System.out.println(sum);

    }
}
