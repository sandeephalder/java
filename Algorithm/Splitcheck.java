package com.java.algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitcheck {

    static String uri = "/api/instances/nasServer/5d4cfdee-e498-60ee-b08c-16604b461d90";



    public static void main(String[] args){
       /* System.out.println(uri.contains("/"));
        System.out.println(splituri(uri));
*/
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("asgf","hltj","ghalsgag","poritoerkt","ouetlkejgnksdngv.","ortiylkdfjgbkl.fd","smndvbkjsafhdjsakfhs",null));

        list.stream().filter(str-> str != null && str.length()>4 && str.contains("a")).forEach(System.out::println);



    }

    private static String splituri(String ur){
        String[] fields = ur.split("\\/");
        System.out.println(fields.length);
        return fields[4];
    }


}
