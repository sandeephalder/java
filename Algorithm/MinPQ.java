package com.java.algo1;

import java.util.EmptyStackException;

public class MinPQ {

    int arr[], CAPACITY = 20, TOP = 0;

    MinPQ() {
        arr = new int[CAPACITY];
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.MAX_VALUE;
    }

    public static void main(String... ags) {
        MinPQ pq = new MinPQ();
        pq.offer(23);
        pq.offer(56);
        pq.offer(2);
        pq.offer(12);
        pq.offer(658);
        pq.offer(1);
        pq.offer(8897);
        pq.offer(10000);
        pq.offer(9);
        pq.offer(9873948);
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());

        pq.print();
    }

    public void offer(int val) {
        if (TOP >= CAPACITY)
            throw new ArrayIndexOutOfBoundsException("Priority Queue is full");
        arr[++TOP] = val;
        swim(TOP);
    }

    private void print(){
        for(int v: arr)
        {
            System.out.println("==>"+v);
        }
    }
    private void swim(int index){
      int v = arr[index];
      while(v<arr[index/2]&& index/2>=0){
          exch(index,index/2);
          index=index/2;
          v = arr[index];

      }
    }

    public int deleteMin(){
        int val = arr[0];
        if(TOP<=0)
            throw new EmptyStackException();
        arr[0] = arr[TOP--];
        arr[TOP+1]=Integer.MIN_VALUE;
        sink(0);
        return val;
    }

    private void sink(int index){
    int v = index;
    while(index*2<TOP){
        v = index;
        index*=2;
        if(arr[index]>arr[index+1]) index++;
        if(arr[index] < arr[v])
            exch(v,index);
        else break;

    }
    }

    private void exch(int src,int dest){
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
}
