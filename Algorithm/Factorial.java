package com.java.algo2;

public class Factorial {

    public static void main(String ar[]){
        Factorial fact = new Factorial();
        for(int i=0;i<=10;i++)
        System.out.print("==>"+fact.recuesiveFibonicci(i));
        System.out.println();
        for(int i=0;i<=10;i++)
            System.out.print("==>"+fact.iterativeFibonicci(i));
    }

    private int recuesiveFibonicci(int val){
        if(val<1)
            return 1;

        return val*recuesiveFibonicci(val-1);
    }


    private int iterativeFibonicci(int n){
        int fib =1;

        for(int i=1;i<=n;i++)
            fib*=i;

            return fib;
    }
}
