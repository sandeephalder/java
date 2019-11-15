package com.java.algo2;

public class QuickSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,41,3244,534,35,4,12};

    public static void main(String ... ar){

        QuickSort sort = new QuickSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        sort(a,0,a.length-1);
        print(a);
    }

    private void sort(int[] a,int lo,int hi){
        if(hi<=lo)
            return;

      int j= partition(a,lo,hi);
      sort(a,lo,j-1);
      sort(a,j+1,hi);
    }

    private int partition(int[] a,int lo,int hi){
       int j=lo,k=hi+1,partition=a[lo];
       while(true){
           while(a[++j]<partition)
               if(j==hi) break;
           while(a[--k]>partition)
               if(k==lo)
                   break;
           if(j>=k) break;
           exch(a,j,k);
       }
       exch(a,lo,k);
       return k;
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
