package com.java.algo2;

public class TreeDynamicConnectivity {


    int MAX=11,arr[];

    public static void main(String ... ar){
        TreeDynamicConnectivity connect = new TreeDynamicConnectivity();

        connect.connect(1,5);
        connect.connect(8,5);
        connect.connect(3,6);
        connect.connect(2,7);
        connect.connect(10,9);
        connect.connect(6,9);
        connect.connect(1,4);
        connect.connect(2,5);
        System.out.println(""+connect.isConnected(9,7));

    }

    TreeDynamicConnectivity(){
        arr = new int[MAX];
        for(int i=0;i<arr.length;i++)
            arr[i]=i;
    }

    public int root(int node){
        while(arr[node]!=node)
            node=arr[node];
        return node;
    }

    public void connect(int a, int b){
        int a_val = root(a),b_val=root(b);
        arr[a_val] = b_val;
    }

    public boolean isConnected(int a,int b){
        return root(a)==root(b);
    }
}
