package com.java.algo2;

public class BinaryHeap {

    int arr[],N=10,TOP=0;

    public static void main(String ... a){
        BinaryHeap heap = new BinaryHeap();
        heap.insert(12);
        heap.insert(4);
        heap.insert(213);
        heap.insert(78867);
        heap.insert(1233);
        heap.insert(9758);
        heap.insert(143213);
        heap.insert(67);
        heap.print();
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
        System.out.println(heap.deleteMin());
    }

    BinaryHeap(){
        arr = new int[N];
    }

    public void insert(int val){
        arr[++TOP]=val;
        swim(TOP);
    }

    public int deleteMin(){
        int val=arr[1];
        exch(arr,1,TOP--);
        sink(1);
        arr[TOP+1]=Integer.MIN_VALUE;
        return val;
    }

    private void exch(int[] a , int b ,int d){
        int temp = a[b];
        a[b]=a[d];
        a[d]= temp;
    }

    private void sink(int index){
        while(2*index<=TOP){
            int i=2*index;
            if(arr[i+1]>arr[i]) i++;
            if(i>=TOP) break;
            if(arr[i]> arr[index]) exch(arr,i,index);
            index=i;
        }
    }

    private void swim(int index){
        while(arr[index]>arr[index/2] && index > 1){
            exch(arr,index,index/2);
            index=index/2;
        }

    }

    private void print(){
        for(int s:arr)
            System.out.print("==>"+s);
        System.out.println("=====================End===================");
    }
}
