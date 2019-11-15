package com.java.algo3;

public class QuickSort {

    int arr[] ={45,4569,413,4654,54,341,3,32,3244,534,45,35,4,12};

    public static void main(String ... ar){

        QuickSort sort = new QuickSort();
        sort.sort(sort.arr);
    }

    private void sort(int[] a){
        print(a);
        sort(arr,0,arr.length-1);
        //print(a);
    }

    private void sort(int[] a,int lo,int hi){
        if(lo>=hi) return;
        int partion = partion(a,lo,hi);

        //sort(a,lo,partion-1);
        //sort(a,partion+1,hi);

    }
//3==>4==>12==>32==>35==>45==>45==>54==>341==>413==>534==>3244==>4569==>4654
    private int partion(int[] a,int lo,int hi){
       int j=lo,k=hi+1,i=lo;
       while(true){
             while(a[++i]<=a[j] && i<hi );
             while(a[--k]>a[j] && k>lo);


           if(i>=k)
               break;
           exch(a,i,k);
           print(a);
           System.out.println(i+"partion="+k);
        }
        System.out.println(i+"partion="+k);
        print(a);
       exch(arr,j,k);
       // print(a);

       return k;
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
