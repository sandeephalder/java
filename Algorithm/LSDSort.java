package com.java.algo2;

public class LSDSort {
    String[] arr={"kghjk","wutuk","sdgnv","oirrt","cbfou","cguyn","hekrh","uwelt","yetbk","aksguievna",null},aux;
    int count[] = new int[256];

    public static void main(String... ar){
        LSDSort sort = new LSDSort();

    }

    LSDSort(){

        print();
        aux = new String[arr.length];
        for(int j=23;j>=0;j--){

            count = new int[256];

            for(int i=0;i<arr.length;i++)
                count[charAt(arr[i],j)+1]++;



            for(int i=0;i<count.length-1;i++)
                count[i+1]+=count[i];


            for(int i=0;i<arr.length;i++){
                aux[count[charAt(arr[i],j)]++]=arr[i];
            }

            for(int i=0;i<arr.length;i++)
                arr[i]=aux[i];
        }

        print();
    }

    private void print(){
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print("==>"+arr[i]);
        System.out.println();
    }

    private int charVal(char c){
        return (int)c - 96;
    }

    private int charAt(String str, int index){

        if(str ==null || index >= str.length()) return 0;
        return charVal(str.charAt(index));
    }

}
