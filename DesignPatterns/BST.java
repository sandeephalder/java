package com.algo.algo3;

public class BST {

    Node root;

    public static void main(String ... ar){

        BST tree = new BST();
    }

    class Node{
        int val;
        Node lNode,rNode;

        public Node(int val) {
            this.val = val;
        }
    }


    BST(){

        root=insert(root,45);
        root=insert(root,16);
        root= insert(root,9);
        root=insert(root,321);
        root=insert(root,90);
        root= insert(root,435);
        preorder(root);
        //System.out.println(min());
        //System.out.println(max());

    }

    void preorder(Node node){
        if(node==null) return;
        preorder(node.lNode);
        System.out.println();
        preorder(node.rNode);
    }

    private Node insert(Node node,int val){
        if(node==null) return new Node(val);

        if(val<node.val)
        node.lNode= insert(node.lNode,val);
        else if(val > node.val)
        node.rNode = insert(node.rNode,val);
        else node.val=val;

        return node;
    }
}
