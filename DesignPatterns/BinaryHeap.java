package com.algo.algo3;

public class BinaryHeap {
     int[] arr;
     int N=20,pointer=0;

    public static void main(String ... ar){

        BinaryHeap sort = new BinaryHeap();
    }


    BinaryHeap(){
     arr = new int[N];

        insert(6);
        insert(16);
        insert(9);
        insert(321);
        insert(90);
        insert(435);
        System.out.println(deleteMax());
        System.out.println(deleteMax());
        System.out.println(deleteMax());

    }

    void print(){
         for(int i:arr)
             System.out.print("==>"+i);
         System.out.println();
    }

    private void insert(int val){
        arr[++pointer]= val;
        swim(pointer);
        print();
    }

    private int deleteMax(){
        int val = arr[0];
        exch(arr,0,pointer--);
        arr[pointer+1]=Integer.MIN_VALUE;
        sink(0);
       return val;
    }

    private void swim(int v){
        while(arr[v]>arr[v/2]){
            exch(arr,v,v/2);
            v=v/2;
        }
    }
    private void sink(int v){
        int i=2*v;
       while(i<N-1){
           i=2*v;
           if(i>N-1) break;
           if(arr[i+1]>arr[i]) i++;
           if(arr[i]>arr[v]) exch(arr,i,v);
           else break;
           v=i;
       }
    }

    private void exch(int[] a , int b ,int d){
        int temp = a[b];
        a[b]=a[d];
        a[d]= temp;
    }
}
