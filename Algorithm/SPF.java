package com.java.algo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class SPF {

    List<Edge>[] arr;
    boolean visited[];
    int N=10;
    Edge edgeTo[];
    float[] distTo;
    IndexMinPQ<Float> pq = new IndexMinPQ<>(N);
    Stack<Integer> topological = new Stack();



    SPF(){
        arr = (List<Edge>[] )new ArrayList[N];
        visited =new  boolean[N];
        edgeTo =new Edge[N];
        distTo = new float[N];
        for(int i=0;i< arr.length;i++){
            visited[i]=false;
            arr[i]=new ArrayList<>();
            edgeTo[i]=null;
            distTo[i]=Float.POSITIVE_INFINITY;
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
        SPF graph = new SPF();
        graph.fordFurgasonDAG();

       /*   for(Edge e : graph.edgeTo)
         System.out.print("==>"+e); */
        System.out.println();
        for(float e : graph.distTo)
            System.out.print("==>"+e);
    }

    private List<Edge> adj(int v){
        return arr[v];
    }

    private void addNode(Edge edge){
        arr[edge.current()].add(edge);
    }

    private void diacktrars_spf(int v){

        distTo[v]=0.0f;
        pq.insert(v,0.0f);

        while (!pq.isEmpty()){
            int w= pq.delMin();
            for (Edge e : adj(w)){
                relax(e);
            }
        }

    }

    private void relax(Edge edge){
         int v=edge.current(),w= edge.other(edge.current());

         if(distTo[w]>distTo[v]+edge.w){
             distTo[w] = distTo[v]+edge.w;
             edgeTo[w]=edge;
             System.out.print("==>"+edge);
             if(pq.contains(w)) pq.decreaseKey(w,distTo[w]);
             else pq.insert(w,distTo[w]);
         }
    }


private  void topological(int v){
        visited[v]=true;
        for (Edge edge: adj(v)){
            if(!visited[edge.other(v)])
            {
                topological(edge.other(v));
            }
        }

        topological.push(v);
}

    private void edgeWeightedDAG(int v){
        topological(v);
        distTo[v]=0.0f;
        pq.insert(v,0.0f);

        while(!topological.isEmpty()){
            Integer w = topological.pop();
            for(Edge edge: adj(w))
                relax(edge);

        }

    }

    private void fordFurgasonDAG(){

        distTo[0]=0.0f;
        pq.insert(0,0.0f);

        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                for (Edge edge:adj(j))
                relax(edge);
    }



    class Edge implements  Comparable<Edge>{

        int a,b;
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
                    Float.compare(node.w, w) == 0;
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, b, w);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "a=" + a +
                    ", b=" + b +
                    ", w=" + w +
                    '}';
        }
    }



}
