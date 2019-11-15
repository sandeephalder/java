package com.java.algo2;

public class ArrayStack {

    int N=20, TOP=0;
    String[] arr = new String[N];

    public static void main(String... arr){
        ArrayStack stack = new ArrayStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public void push(String val){
        if(TOP<N)
            arr[TOP++] = val;
    }


    public void print(){

    }

    public String pop(){
        if(TOP<=0)
            return "Empty Stack";
        return arr[--TOP];
    }

}
