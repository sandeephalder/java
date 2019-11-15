package com.java.algo2;

import java.util.*;
import java.util.LinkedList;

public class MST {

    List<Edge>[] arr;
    boolean visited[];
    int N=10,connected[];
    LinkedList<Edge> mst = new LinkedList<Edge>();
    MinPQ<Edge> pq = new MinPQ<>();

    TreeDynamicConnectivity connectivity = new TreeDynamicConnectivity();



    MST(){
        arr = (List<Edge>[] )new ArrayList[N];
        visited =new  boolean[N];
        connected =new int[N];
        for(int i=0;i< arr.length;i++){
            visited[i]=false;
            arr[i]=new ArrayList<Edge>();
            connected[i]=i;
        }

       addNode(new Edge(0,1,4));
       addNode(new Edge(0,2,3));
       addNode(new Edge(2,4,2));
       addNode(new Edge(1,4,5));
       addNode(new Edge(4,6,3));
       addNode(new Edge(4,7,6));
       addNode(new Edge(6,8,2));
       addNode(new Edge(7,9,7));
       addNode(new Edge(8,9,5));
    }

    public static void main(String ... ar){
        MST graph = new MST();
        graph.prims_mst();
        for(Edge e:graph.mst)
            System.out.print("===>"+e);
    }

    private boolean isConnected(Edge a){
        return connected[a.current()]==connected[a.other(a.current())];
    }



    private List<Edge> adj(int v){
        return arr[v];
    }

    private void addNode(Edge edge){
         arr[edge.current()].add(edge);
         mst.add(edge);
    }
// ===>Node{a=2, b=4, val=0, w=2.0}===>Node{a=6, b=8, val=0, w=2.0}===>Node{a=4, b=6, val=0, w=3.0}===>Node{a=0, b=2, val=0, w=3.0}===>Node{a=0, b=1, val=0, w=4.0}===>Node{a=8, b=9, val=0, w=5.0}===>Node{a=4, b=7, val=0, w=6.0}
    private void kruskas_mst(){
        for(Edge edge :mst){
            pq.insert(edge);
        }

        mst= new LinkedList<Edge>();

        Edge first = pq.delMin();



        connectivity.connect(first.current(),first.other(first.current()));

        mst.add(first);

        while(!pq.isEmpty() && mst.size()<10){
            first = pq.delMin();
            if(!connectivity.isConnected(first.current(),first.other(first.current()))){
                connectivity.connect(first.current(),first.other(first.current()));
                mst.add(first);
            }
        }
    }


    private void prims_mst(){
        mst= new LinkedList<Edge>();
        visit(0);
        while(!pq.isEmpty()){
                Edge edge = pq.delMin();
                if(visited[edge.current()]&& visited[edge.other(edge.current())]) continue;
                 mst.add(edge);
            if(!visited[edge.current()]) visit(edge.current());
            if(!visited[edge.other(edge.current())]) visit(edge.other(edge.current()));

        }
    }

    private void visit(int a){
        visited[a]=true;
        for(Edge edge:adj(a)){
            if(!visited[edge.other(a)]){
                pq.insert(edge);
            }
        }
    }


 class Edge implements  Comparable<Edge>{

        int a,b,val;
        float w;

     public Edge(int a, int b,  float w) {
         this.a = a;
         this.b = b;
         this.w = w;
     }

     public int current(){
         return a;
     }

     public int other(int v){
         if(v==a) return b;
         else return a;
     }

     @Override
     public int compareTo(Edge a){
         return Float.valueOf(w).compareTo(Float.valueOf(a.w));
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Edge node = (Edge) o;
         return a == node.a &&
                 b == node.b &&
                 val == node.val &&
                 Float.compare(node.w, w) == 0;
     }

     @Override
     public int hashCode() {

         return Objects.hash(a, b, val, w);
     }

     @Override
     public String toString() {
         return "Node{" +
                 "a=" + a +
                 ", b=" + b +
                 ", val=" + val +
                 ", w=" + w +
                 '}';
     }
 }






}
