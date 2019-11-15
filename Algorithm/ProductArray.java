package com.java.algo2;

public class ProductArray {


    public static void main(String s[]){

        int arr[] = {10,3,5,6,2}, temp1[] = new int[arr.length], temp2[] = new int[arr.length];
        long product=0;

        for(int i=0;i<arr.length;i++)
            temp1[i]=temp2[i]=arr[i];

        for(int i=1;i<arr.length;i++)
            temp1[i]=arr[i]*arr[i-1];

        for(int i=arr.length-1;i>=0;i--)
            temp2[i]=arr[i]*arr[i+1];

        for(int i=0;i<arr.length-1;i++){
            int a=0,b=0;
            if(i>0)
                a=temp1[i-1];
            if(i<arr.length-1)
                a=temp2[i+1];
            arr[i]=a+b;
        }

        for(int a: arr)
            System.out.print(a+"==>");


    }

}
