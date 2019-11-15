package com.java.algo2;

public class RBT {


    public static void main(String... a) {
        RBT bst = new RBT();
        Node root = null;
        root = bst.insert(root, 234);
        root = bst.insert(root, 1);
        root = bst.insert(root, 2366);
        root = bst.insert(root, 76358);
        root = bst.insert(root, 245);
        System.out.println("Inorder");
        bst.inorder(root);
        /*
         *//* System.out.println(bst.search(root,2366));
        System.out.println(bst.search(root,1));
        System.out.println(bst.search(root,12));
        System.out.println(bst.search(root,245));

        System.out.println("Min:"+bst.min(root));

        System.out.println("Max:"+bst.max(root));*//*
        System.out.println("Pre order");
        bst.preorder(root);
        System.out.println("Post order");
        bst.postorder(root);*/


    }


    public void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.lNode);
        System.out.println(node.val);
        inorder(node.rNode);
    }

    public Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);

        if (val < node.val)
            node.lNode = insert(node.lNode, val);
        else if (val > node.val)
            node.rNode = insert(node.rNode, val);
        else node.val = val;

        if (!isRed(node.lNode) && isRed(node.rNode)) node = rotateLeft(node);
        if (isRed(node.lNode) && isRed(node.lNode.lNode)) node = rotateRight(node);
        if (isRed(node.lNode) && isRed(node.rNode)) flipColor(node);
        return node;
    }

    private Node rotateLeft(Node t) {
        Node x = t.rNode;
        t.rNode = x.lNode;
        x.lNode = t;
        x.red = t.red;
        t.red = true;
        return t;
    }

    private Node rotateRight(Node t) {
        Node x = t.rNode;
        t.lNode = x.rNode;
        x.rNode = t;
        x.red = t.red;
        t.red = true;
        return t;
    }

    private Node flipColor(Node t) {
        t.lNode.red = false;
        t.rNode.red = false;
        t.red = true;
        return t;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.isRed();
    }

    class Node {
        int val;
        Node rNode, lNode;
        boolean red = false;


        public boolean isRed() {
            return red;
        }

        public void setRed(boolean red) {
            this.red = red;
        }

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getrNode() {
            return rNode;
        }

        public void setrNode(Node rNode) {
            this.rNode = rNode;
        }

        public Node getlNode() {
            return lNode;
        }

        public void setlNode(Node lNode) {
            this.lNode = lNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", red=" + red +
                    '}';
        }
    }

}
