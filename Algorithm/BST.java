package com.java.algo2;

public class BST {


    public Node root = null;


    public static void main(String... a) {
        BST bst = new BST();

        bst.root = bst.insert(bst.root, 234);
        bst.root = bst.insert(bst.root, 100);
        bst.root = bst.insert(bst.root, 4);
        bst.root = bst.insert(bst.root, 1);
        bst.root = bst.insert(bst.root, 10);
        bst.root = bst.insert(bst.root, 103);
        bst.root = bst.insert(bst.root, 2366);
        bst.root = bst.insert(bst.root, 76358);
        bst.root = bst.insert(bst.root, 245);
        System.out.println("Inorder");
        bst.inorder(bst.root);
        System.out.println("Celling"+bst.celing(bst.root,5));

        System.out.println("Floor"+bst.floor(bst.root,5));

        System.out.println("Ramk"+ bst.rank(bst.root,1));

       /* System.out.println(bst.search(bst.root,2366));
        System.out.println(bst.search(bst.root,1));
        System.out.println(bst.search(bst.root,12));
        System.out.println(bst.search(bst.root,245));

        System.out.println("Min:"+bst.min(bst.root));

        System.out.println("Max:"+bst.max(bst.root));*/
        //System.out.println("Pre order");
        //bst.preorder(bst.root);
        //System.out.println("Post order");
        //bst.postorder(bst.root);


    }

    public Node min(Node node) {
        while (node != null && node.lNode != null)
            node = node.lNode;
        return node;

    }

    public Node max(Node node) {
        while (node != null && node.rNode != null)
            node = node.rNode;
        return node;

    }

    public Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);

        if (node.val < val)
            node.rNode = insert(node.rNode, val);
        else if (node.val > val)
            node.lNode = insert(node.lNode, val);
        else
            node.val = val;

        node.size = size(node.lNode) + 1 + size(node.rNode);

        return node;

    }

    public Node search(Node node, int val) {
        if (node == null)
            return null;

        if (node.val > val)
            return search(node.lNode, val);
        else if (node.val < val)
            return search(node.rNode, val);
        else
            return node;
    }

    private int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.getSize();
    }


    public void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.lNode);
        System.out.println(node.val);
        inorder(node.rNode);
    }

    private int rank(Node node, int val) {
        if (node == null)
            return 0;

        if (val < node.val) return rank(node.lNode, val);
        else if (val > node.val) return rank(node.rNode, val) + 1 + size(node.lNode);
        else return size(node.lNode);
    }

    private Node floor(Node node, int val) {
        if (node == null) return null;

        if (val == node.val) return node;

        if (val < node.val) return floor(node.lNode, val);

        Node t = floor(node.rNode, val);
        if (t != null) return t;
        else return node;
    }

    private Node celing(Node node, int val) {
        if (node == null) return null;


        if (val == node.val) return node;

        if (val > node.val) return celing(node.rNode, val);

        Node t = celing(node.lNode, val);
        if (t != null) return t;
        else return node;
    }


    public void preorder(Node node) {
        if (node == null)
            return;
        System.out.println(node.val);
        preorder(node.lNode);
        preorder(node.rNode);
    }


    public void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.lNode);
        postorder(node.rNode);
        System.out.println(node.val);
    }


    class Node {
        int val;
        Node rNode, lNode;
        int size = 1;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
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

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

}
