package com.java.algo2;

public class Fibonicci {

    int arr[] = new int[10000];
    int j=0,k=0;
    public static void main(String ... c){

        Fibonicci fib = new Fibonicci();

        //for(int i=0;i<=10;i++)
        System.out.print("==>"+fib.dynamicrecussveFib(20));
        System.out.print("==>"+fib.recussveFib(20));
        System.out.println("Inside recussveFib"+ fib.k);
        System.out.println("Inside dynamicrecussveFib"+ fib.j);
        System.out.println();
        fib.iterativeFibonicci(10);
    }

    Fibonicci(){
        for(int i=0;i<arr.length;i++)
            arr[i]=-1;
    }

    private int recussveFib(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        k++;
        return  recussveFib(n-2) + recussveFib(n-1);
    }

    private void iterativeFibonicci(int n){
        int prev=0,newer=1,fib=0;
        for(int i=0;i<=n;i++){
            fib = prev+newer;
            if(i==0)
                fib=0;
            System.out.print("==>"+fib);
            prev=newer;
            newer=fib;
        }
    }

    private int dynamicrecussveFib(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        j++;
        if(arr[n]!=-1)
            return arr[n];

        arr[n]=recussveFib(n-2) + recussveFib(n-1);
        return  arr[n];
    }

}
