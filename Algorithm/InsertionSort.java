package com.java.algo2;

public class InsertionSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};

    public static void main(String ... ar){

        InsertionSort sort = new InsertionSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        for(int i=0 ;i< a.length-1;i++){
            for(int j=i+1;j>=1;j--){
                if(a[j]<a[j-1])
                    exch(a,j,j-1);
            }
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
