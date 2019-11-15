package com.java.algo2;

public class Tree {

    Node root=null;

    class Node{
        Node left,right;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String str[]){
        Tree tree = new Tree();

    }

    Tree(){
       root = insert(root,12);
        root = insert(root,5);
        root = insert(root,22);
        root = insert(root,1);
        root = insert(root,50);
        System.out.println(get(root,1));
        inorder(root);

    }

    public Node insert(Node node,int val){
        if(node == null)
            return new Node(val);

        if(val < node.val)
            node.left = insert(node.left,val);
        else if(val> node.val)
            node.right = insert(node.right,val);
        else
            node.val= val;
        return node;
    }


    public Node get(Node node,int val){
        if(node == null)
            return null;
        System.out.println(node);
        if(val < node.val)
            node = get(node.left,val);
        else if(val> node.val)
            node = get(node.right,val);

        return node;
    }

    public void inorder(Node node){
        if(node == null)
            return ;

        inorder(node.left);
        System.out.print("==>"+node.val);
        inorder(node.right);
    }



}
