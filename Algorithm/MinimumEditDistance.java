package com.java.algo2;

public class MinimumEditDistance {

    String a1="adas",a2="asas";

    public static void main(String a[]){
        MinimumEditDistance min = new MinimumEditDistance();
    }

    MinimumEditDistance(){
      System.out.println(minEditDistance(a1,a2,(a1.length()-1),(a2.length()-1)));
    }

    private int minEditDistance(String b1,String b2,int m,int n){

        if(m==0)
            return n;

        if(n==0)
            return m;

        if(b1.charAt(m-1)==b2.charAt(n-1)) return minEditDistance(b1,b2,m-1,n-1);

        return 1+ min(minEditDistance(b1,b2,m,n-1),minEditDistance(b1,b2,m-1,n),minEditDistance(b1,b2,m-1,n-1));
    }




    private int min(int a,int b,int c){
        int d;
        d=Math.min(a,b);
        return Math.min(d,c);
    }
}
