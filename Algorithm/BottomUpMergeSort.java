package com.java.algo2;

public class BottomUpMergeSort {


    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};

    public static void main(String ... ar){

        BottomUpMergeSort sort = new BottomUpMergeSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        sort(a,0,a.length-1);
        print(a);
    }

    private void sort(int[] a,int lo,int hi){
       for(int sz=1;sz<arr.length;sz=2*sz)
           for(int i=0;i<arr.length-sz;i+=sz*2)
               merge(a,i,i+sz-1,Math.min(i+sz*2-1,arr.length-1));
    }

    private void merge(int[] a,int lo,int mid,int hi){
        int[] aux = new int[a.length];

        for(int i=lo;i<=hi;i++)
            aux[i]=a[i];

        int j=lo,k=mid+1;

        for(int l=lo;l<=hi;l++){
            if(j>mid) a[l]= aux[k++];
            else if(k>hi) a[l] = aux[j++];
            else if(aux[j] < aux[k]) a[l]= aux[j++];
            else a[l] = aux[k++];
        }

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
