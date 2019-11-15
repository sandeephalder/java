package com.java.algo2;

public class LinkedQueue {


    Node head=null,tail=null;


    public static void main(String... arr){
        LinkedQueue stack = new LinkedQueue();
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

        if(head==null){
            head = new Node(val);
            tail=head;
            return;
        }
        if(head==tail){
            tail = new Node(val);
            head.nextNode=tail;
            return;
        }
        Node oldtail = tail;
        tail = new Node(val);
        oldtail.nextNode=tail;
    }


    public void print(){
        Node pointer=head;
        if(pointer==null) return;
        while(pointer!=null){
            System.out.print("===>"+pointer.value);
            pointer=pointer.nextNode;
        }

    }

    public String dequeue(){
        if(head==null) return "Empty Queue";
        String val = head.value;

        head=head.nextNode;
        return val;

    }

    class Node{

        String value;
        Node nextNode;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
