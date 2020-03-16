package com.sandeep.sf.al.first.week1;

public class QuickFind {

    int arr[],N=10;

    QuickFind(){
        arr = new int[N];
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind();
        qf.connect(0,5);
    }

    public void connect(int src,int dest){
        int srcd = arr[src],destd=arr[dest];
        for(int i=0;i<N;i++)
            if(arr[i]==srcd)
                arr[i]=destd;
    }

    public boolean isConnected(int src,int dest){
        return arr[src]==arr[dest];
    }


}
