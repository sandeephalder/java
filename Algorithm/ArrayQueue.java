package com.java.algo2;

public class ArrayQueue {

    int N=20, head=0,tail=0;
    String[] arr = new String[N];


    public static void main(String... arr){
        ArrayQueue stack = new ArrayQueue();
        stack.enqueue("1");
        stack.enqueue("2");
        stack.enqueue("3");
        stack.enqueue("4");
        stack.enqueue("5");
        stack.print();
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());


        stack.enqueue("10");
        stack.enqueue("20");
        stack.enqueue("30");
        stack.enqueue("40");

        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());

    }

    public void enqueue(String val){
        if(tail>N)
            System.out.println("Queue full");
     arr[tail++]=val;
    }


    public void print(){

    }

    public String dequeue(){
        if(head>=tail)
            System.out.println("Empty Queue");
        return arr[head++];
    }

}
