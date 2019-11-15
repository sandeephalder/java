package com.java.algo2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringArraySort {

    String[] str = {"100 gbps","12 kbps","34 mbps","65 bps","1 gbps","23323 kbps","643 mbps","786 bps"};
    Map<String,Long> dict=new HashMap<>();
    Map<Long,String> sorted = new TreeMap<>();

    StringArraySort(){
       /* dict.put("gbps",1000*1000*1000L);
        dict.put("mbps",1000*1000L);
        dict.put("kbps",1000L);
        dict.put("bps",1L);

        for(String s:str){
            sorted.put(returnValue(s),s);
        }

        for(Long l : sorted.keySet())
            System.out.println(l+"==>"+sorted.get(l));*/

       TreeMap<Integer,Integer> tree = new TreeMap<>();

       tree.put(12,1);
        tree.put(3,1);
        tree.put(546,1);
        tree.put(-1,1);
        String s ="123456";
        System.out.println(s.substring(1,s.length()));

    }

    public  static void main(String[] a){
        StringArraySort sort = new StringArraySort();

    }

    private Long returnValue(String value){
        return dict.get(value.split(" ")[1])*Integer.valueOf(value.split(" ")[0]);
    }



}
