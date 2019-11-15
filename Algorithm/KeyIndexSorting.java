package com.java.algo2;

public class KeyIndexSorting {

    char[] arr={'a','k','c','n','w','j','f','t','w','y','d','h','w','d'},aux;
    int count[] = new int[256];

    public static void main(String... ar){
        KeyIndexSorting sort = new KeyIndexSorting();

    }

    KeyIndexSorting(){

        print();

        aux = new char[arr.length];
        for(int i=0;i<arr.length;i++)
            count[charVal(arr[i])+1]++;

        for(int i=0;i<count.length-1;i++)
            count[i+1]+=count[i];

        for(int i=0;i<arr.length;i++)
            aux[count[charVal(arr[i])]++]=arr[i];

        for(int i=0;i<arr.length;i++)
            arr[i]=aux[i];

        print();
    }

    private void print(){
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print("==>"+arr[i]);
        System.out.println();
    }

    private int charVal(char c){
        return (int)c - 97;
    }
}
