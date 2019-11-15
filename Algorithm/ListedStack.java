package com.java.algo2;

public class ListedStack {

    Node head=null;


    public static void main(String... arr){
        ListedStack stack = new ListedStack();
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

        if(head==null){
            head = new Node(val);
            return;
        }
        Node oldhead = head;
        head = new Node(val);
        head.nextNode=oldhead;
    }


    public void print(){
        if(head==null) return;
        while(head!=null){
            System.out.print("===>"+head.value);
            head=head.nextNode;
        }

    }

    public String pop(){
        if(head==null) return "Empty Stack";
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
