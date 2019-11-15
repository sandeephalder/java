package com.java.algo2;

public class SelectionSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};

    public static void main(String ... ar){

        SelectionSort sort = new SelectionSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        int lowpointer=0;
        for(int i=0 ;i< a.length;i++){
            lowpointer=i;
            for(int j=i;j<a.length;j++){
                if(a[lowpointer]<a[j])
                    lowpointer=j;
            }
            exch(a,i,lowpointer);
        }
        print(a);
    }

    private void print(int[] a){
        for(int s:a)
            System.out.print("==>"+s);
        System.out.println("=====================End===================");
    }

    private void exch(int[] a , int b ,int d){
        int temp = a[b];
        a[b]=a[d];
        a[d]= temp;
    }
}
