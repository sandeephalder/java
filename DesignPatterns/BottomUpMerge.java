package com.algo.algo3;

public class BottomUpMerge {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};
    int aux[];

    public static void main(String ... ar){

        BottomUpMerge sort = new BottomUpMerge();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        aux  = new int[arr.length];
        print(a);
        for(int sz=1;sz<arr.length;sz*=2){
            for(int lo=0;lo<arr.length-sz;lo=lo+2*sz){
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz,arr.length)-1);
            }
        }
        print(a);
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
