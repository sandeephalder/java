package com.java.algo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
     List arr[] ;
     boolean visited[];
    int N=10,connected[];


    Graph(){
        arr = new ArrayList[N];
        visited =new  boolean[N];
        connected =new int[N];
         for(int i=0;i< arr.length;i++){
            visited[i]=false;
            arr[i]=new ArrayList<Integer>();
            connected[i]=i;
        }


    }

    public static void main(String ... ar){
        Graph graph = new Graph();
        graph.addNode(1,3);
        graph.addNode(1,5);
        graph.addNode(1,8);
        //graph.addNode(3,6);
        graph.addNode(9,3);
        graph.addNode(8,4);
        graph.addNode(6,0);
        graph.addNode(7,6);
        graph.addNode(6,2);


        int j=0;

        for(int i=0;i<10;i++){
            if(!graph.visited[i])
            graph.dfs(i,j++);

        }
        System.out.println();
        for(int i=0;i<10;i++)
            System.out.print("==>"+graph.connected[i]);

        System.out.println(graph.isConnected(1,3));
        System.out.println(graph.isConnected(2,9));


    }

    private boolean isConnected(int v,int w){
        return connected[v]==connected[w];
    }

    private void addNode(int v, int k){
        arr[v].add(k);
        arr[k].add(v);
    }

    private List<Integer> adj(int v){
        return arr[v];
    }

    private void dfs(int v,int l){
        visited[v]=true;
        connected[v]=l;
        System.out.print("==>"+v);
        for(int k:adj(v)){
            if(!visited[k])
                dfs(k,l);
        }
    }

    private void bfs(int v){
        LinkedList<Integer> bfs = new LinkedList<>();
        bfs.push(v);
        while(!bfs.isEmpty()){
            int k = bfs.pop();
            visited[k]=true;
            System.out.print("==>"+k);
            for(int r:adj(k)){
                if(!visited[r]) bfs.push(r);
            }
        }
    }
}
