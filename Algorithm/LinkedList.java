package com.java.algo2;


public class LinkedList {
    
    Node head ,tail;

    public static void main(String ... ar){
        LinkedList graph = new LinkedList();
        graph.addhead(1);
        graph.addhead(2);
        graph.addhead(3);
        graph.addhead(4);
        graph.addhead(5);
        graph.addTail(6);
        graph.addTail(7);
        graph.addTail(8);
        graph.addTail(9);
        graph.print();
        graph.addMiddle(4,10);
        graph.print();
        graph.deleteMiddle(9);
        graph.print();
  /*      graph.deleteFirst();
        graph.deleteLast();
        graph.print();
        graph.deleteFirst();
        graph.deleteLast();
        graph.print();
        graph.deleteFirst();
        graph.deleteLast();
        graph.print();
        graph.deleteFirst();
        graph.deleteLast();
        graph.print();
        graph.deleteFirst();
        graph.deleteLast();
        graph.print();
        graph.addhead(10);
        graph.addTail(11);
        graph.print();*/
       /* System.out.println(graph.adj(1));
        System.out.println(graph.adj(6));
        graph.bfs(1);*/

    }


    private void print(){
        Node pointer =head;
        while(pointer!=null){
            System.out.print("==>"+pointer.value);
            pointer=pointer.nextNode;
        }
        System.out.println();
    }


    private void addhead(int k){
        if(head==null){
            head = new Node(k);
            tail=head;
            return;
        }
        if(head==tail){
            head=new Node(k);
            head.nextNode=tail;
            return;
        }
        Node old = head;
        head = new Node(k);
        head.nextNode=old;
    }

    private void addTail(int k){
        if(head==null){
            head = new Node(k);
            tail=head;
            return;
        }
        if(head==tail){
            tail=new Node(k);
            head.nextNode=tail;
            return;
        }
        Node old = tail;
        tail = new Node(k);
        old.nextNode=tail;
    }

    private void deleteFirst(){
        if(head==null)
            return;
        head=head.nextNode;
    }

    private void deleteLast(){
        if(head==null)
            return;
        Node pointer = head,prev=head;
        while(pointer!=null && pointer.nextNode!=null){
            prev=pointer;
            pointer=pointer.nextNode;
        }
        tail=prev.nextNode;
        prev.nextNode=null;

    }


    private void deleteMiddle(int k){
        Node pointer=head,prev=head;
        while (pointer!=null){
            if(pointer.nextNode!=null)
            {

                if(pointer.value==k){
                    prev.nextNode=pointer.nextNode;
                    return;
                }
                prev=pointer;
                pointer=pointer.nextNode;
            }
            else if(pointer.value==k) {
                deleteLast();
                return;
            }
        }
    }

    private void addMiddle(int v,int k){
        Node pointer=head,prev=head;
        while(pointer!=null){
                if (pointer.nextNode != null) {
                    prev=pointer;
                    pointer=pointer.nextNode;
                    if(pointer.value==v){
                        Node n= new Node(k);
                        n.nextNode=pointer;
                        prev.nextNode=n;
                        return;
                    }
                }
                else if(pointer.value==v)
                    addTail(k);
            }
        }





    class Node{

        int value;
        Node nextNode;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
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
