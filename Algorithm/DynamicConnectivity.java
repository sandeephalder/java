package com.java.algo2;

public class DynamicConnectivity {

    int MAX=11,arr[];

    public static void main(String ... ar){
        DynamicConnectivity connect = new DynamicConnectivity();

        connect.connect(1,5);
        connect.connect(8,5);
        connect.connect(3,6);
        connect.connect(2,7);
        connect.connect(10,9);
        connect.connect(6,9);
        connect.connect(1,4);
        connect.connect(2,5);
        System.out.println(""+connect.isConnected(4,7));

    }

    DynamicConnectivity(){
        arr = new int[MAX];
        for(int i=0;i<arr.length;i++)
            arr[i]=i;
    }

    public void connect(int a, int b){
        int a_val = arr[a];
        for(int i=0;i<arr.length;i++)
            if(arr[i]==a_val)
                arr[i]=arr[b];
    }

    public boolean isConnected(int a,int b){
        return arr[a]==arr[b];
    }
}
