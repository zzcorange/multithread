package com.chengzi.multithread.pool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class FileText {
    public static void main(String...args)throws  Exception {
        File file = new File("D:\\temp\\localhost_access_log.2018-09-30.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        Map<String, Integer> map = new HashMap<String, Integer>();
//        for(int i=0;i<60;i++){
//            map.put("2018:11:"+(i<10?("0"+i):i),0);
//        }
        while ((tempString = reader.readLine()) != null) {
            tempString = tempString.substring(23, 33);
            map.put(tempString, map.get(tempString) == null ? 1 : (1 + map.get(tempString)));
        }
        ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(map.keySet().toArray()));
//        ArrayList<Object> list = new ArrayList<Object>(Arrays.asList("1","2","5","3"));
        list.sort((Object a, Object b) -> {
            String astring = a.toString();
            String bstring = b.toString();
            int i=0,num = astring.length() > bstring.length() ? bstring.length() : astring.length();
            while (i< num) {
                if (astring.charAt(i) != bstring.charAt(i))
                    return astring.charAt(i) > bstring.charAt(i) ? 1 : -1;
                i++;
            }

            return  astring.length() == bstring.length()?0:(astring.length() > bstring.length() ?  1 : -1);
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString().substring(5)+"\t"+map.get(list.get(i).toString()));
        }
    }
}
