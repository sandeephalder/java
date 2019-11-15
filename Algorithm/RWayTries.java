package com.java.algo2;

public class RWayTries {

    Node root=null;

    public static void main(String a[]){

        RWayTries trie = new RWayTries();

    }

    RWayTries(){
        root=put(root,"ac",0);
        root=put(root,"swe",0);
        root=put(root,"ade",0);
        root=put(root,"bew",0);
        root=put(root,"wwe",0);
        root=put(root,"ooi",0);

        System.out.println(get(root,"ac",0));
    }

    class Node{
        Node[] nexts;
        String value;

        public Node(String value) {
            this.value = value;

            nexts = new Node[256];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    private Node put(Node node,String val,int d){
        if(node ==  null) node= new Node(val);
        if(d==val.length()){
            node.value=val;
            return node;
        }
         char c = val.charAt(d);
        //System.out.println(c);
          node.nexts[c] = put(node.nexts[c],val,d+1);
          return node;
    }

    private Node get(Node node,String str,int d){
        if(node==null) return null;
        if(d==str.length())
            return node;
        char c = str.charAt(d);
        System.out.println(d);


        return get(node.nexts[c],str,d+1);

    }
}
