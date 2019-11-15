package com.java.algo3;

public class UnionFind {


    int N=10,arr[] = new int[N];
      public static void main(String ... p){
          UnionFind uf = new UnionFind();
      }

    UnionFind(){
          for(int i=0;i<N;i++){
              arr[i]=i;
          }
/*          connect(1,2);
        connect(1,2);
        connect(2,3);
        connect(3,6);
        connect(5,4);
        connect(5,9);
        connect(8,9);
        System.out.println(isConnected(1,4));
        System.out.println(isConnected(1,6));
        System.out.println(isConnected(6,4));
        System.out.println(isConnected(4,8));*/

        balancedConnect(1,2);
        balancedConnect(1,2);
        balancedConnect(2,3);
        balancedConnect(3,6);
        balancedConnect(5,4);
        balancedConnect(5,9);
        balancedConnect(8,9);
        System.out.println(balancedIsConnected(1,4));
        System.out.println(balancedIsConnected(1,6));
        System.out.println(balancedIsConnected(6,4));
        System.out.println(balancedIsConnected(4,8));



    }

    public void connect(int a,int b){
      int vala = arr[a],valb=arr[b];
      for(int i=0;i<N;i++)
          if(arr[i]==vala)
              arr[i]=valb;

      }

    public boolean isConnected(int a,int b){
        System.out.println("Src = "+a+" dest"+b);
       return arr[a]==arr[b];
    }

    public void balancedConnect(int a,int b){
        arr[root(a)]=arr[root(b)];
    }

    public boolean balancedIsConnected(int a,int b){
        System.out.println("Src = "+a+" dest"+b);
        return root(arr[a])==root(arr[b]);
    }

    public int root(int src){
          while(arr[src]!=src)
              src= arr[src];
          return src;
    }

}
