package com.java.algo2;

public class ThreeWayTries {


    Node root=null;

    public static void main(String a[]){

        ThreeWayTries trie = new ThreeWayTries();

    }

    ThreeWayTries(){
        root=put(root,"ac",0);
        root=put(root,"swe",0);
        root=put(root,"ade",0);
        root=put(root,"bew",0);
        root=put(root,"wwe",0);
        root=put(root,"ooi",0);

        System.out.println(get(root,"ac",0));
    }

    class Node{
        Node left,middle,right;
        String value;
        char key;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    private Node put(Node node,String val,int d){
        char c  = val.charAt(d);
         if(node==null) {
             node=new Node(val);
         }

         if(c<node.key) node.left = put(node.left,val,d);
        else if(c>node.key) node.right = put(node.right,val,d);
        else if(d<val.length()-1) node.middle = put(node.middle,val,d+1);
        else node.value=val;

         return node;
    }

    private Node get(Node node,String val,int d){

        if (node==null) return null;
        char c  = val.charAt(d);

        if(c<node.key) return put(node.left,val,d);
        else if(c>node.key) return put(node.right,val,d);
        else if(d<val.length()-1) return put(node.middle,val,d+1);
        else return node;
    }
}
