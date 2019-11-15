package com.java.algo2;

public class MSD {

    String[] arr={"kghjk","wutuk","sdgnv","oirrt","cbfou","cguyn","hekrh","uwelt","yetbk","aksguievna"},aux;
    int R=256,count[] = new int[R];

    public static void main(String... ar){
        MSD sort = new MSD();

    }

    MSD(){
      aux = new String[arr.length];
      print();
      sort(arr,aux,0,arr.length-1,0);
      print();
    }

    private void sort(String[] a,String[] aux,int lo,int hi,int d){
        if(hi<=lo)
            return;
        count = new int[R+2];

        for(int i=lo;i<=hi;i++)
            count[charAt(arr[i],d)+2]++;

        for(int i=0;i<R+1;i++)
            count[i+1]+=count[i];

        for(int i=lo;i<=hi;i++)
            aux[count[charAt(arr[i],d)+1]++]= arr[i];

        for(int i=lo;i<=hi;i++)
            arr[i]= aux[i-lo];

        for(int i=lo;i<R;i++)
            sort(arr,aux,lo+count[i],lo+count[i+1]-1,d+1);


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
