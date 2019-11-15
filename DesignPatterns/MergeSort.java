package com.java.algo3;

public class MergeSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};
    int aux[];

    public static void main(String ... ar){

        MergeSort sort = new MergeSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        aux  = new int[arr.length];
        print(a);
        sort(arr,aux,0,arr.length-1);
        print(a);
    }

    private void sort(int[] a,int[] aux,int lo,int hi){
        if(lo>=hi) return;

        int mid = lo + (hi-lo)/2;

        sort(arr,aux,lo,mid);
        sort(arr,aux,mid+1,hi);
        merge(arr,aux,lo,mid,hi);
    }

    private void merge(int[] a,int[] aux,int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++)
            aux[i]=a[i];

        int j=lo,k=mid+1;
        for(int i=lo;i<=hi;i++){
            if(j>mid) arr[i]=aux[k++];
            else if(k>hi) arr[i]= aux[j++];
            else if(aux[j]>aux[k]) arr[i]= aux[k++];
            else arr[i] = aux[j++];

        }
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
