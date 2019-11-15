package com.java.algo2;


public class BubbleSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};

    public static void main(String ... ar){

        BubbleSort sort = new BubbleSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(a[i]>a[j])
                    exch(a,i,j);
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
