package com.java.algo3;

public class ThreeWayQuickSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,45,3244,534,35,4,12};

    public static void main(String ... ar){

        ThreeWayQuickSort sort = new ThreeWayQuickSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        sort(arr,0,arr.length-1);
        print(a);
    }

    private void sort(int[] a,int lo,int hi){
        if(lo>=hi) return;
        System.out.println("lo="+lo+" hi= "+hi);
        int i=lo,j=lo,k=hi;
        while(j<=k){
            if(arr[j]<arr[lo])
                exch(a,i++,j++);
            else if(arr[j]>arr[lo])
                exch(a,j,k--);
            else j++;

           // System.out.println("i="+i+" j= "+j+" k="+k);
           // print(a);
        }


       // exch(a,lo,i);
        System.out.println("i="+i+" j= "+j+" k="+k);
        print(a);


        sort(a,lo,i-1);
        sort(a,k+1,hi);

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
