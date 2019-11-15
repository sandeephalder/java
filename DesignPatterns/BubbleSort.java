package com.java.algo3;

public class BubbleSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};

    public static void main(String ... ar){

        BubbleSort sort = new BubbleSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++)
                if(arr[j]>arr[i])
                    exch(arr,i,j);
        print(a);
    }

    private void print(int[] a){
        for(int s:a)
            System.out.print("==>"+s);
        System.out.println("\n=====================End===================");
    }

    private void exch(int[] a , int b ,int d){
        int temp = a[b];
        a[b]=a[d];
        a[d]= temp;
    }
}
