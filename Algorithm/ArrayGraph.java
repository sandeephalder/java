package com.java.algo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayGraph {
    boolean arr[][],visited[];
    int N=10;


    ArrayGraph(){
        arr = new boolean[N][N];
        visited =new  boolean[N];
        for(int i=0;i< arr.length;i++){
            visited[i]=false;
            for(int j=0;j<arr.length;j++)
                arr[i][j]=false;
        }


    }

    public static void main(String ... ar){
        ArrayGraph graph = new ArrayGraph();
        graph.addNode(1,3);
        graph.addNode(1,5);
        graph.addNode(1,8);
        graph.addNode(3,6);
        graph.addNode(9,3);
        graph.addNode(8,4);
        graph.addNode(6,0);
        graph.addNode(7,6);
        graph.addNode(6,2);

        System.out.println(graph.adj(1));
        System.out.println(graph.adj(6));
        graph.bfs(1);

    }

    private void addNode(int v, int k){
        arr[v][k] = true;
        arr[k][v] = true;
    }

    private List<Integer> adj(int v){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            if(arr[v][i])
                list.add(i);
        return list;
    }

    private void dfs(int v){
        visited[v]=true;
        System.out.print("==>"+v);
        for(int k:adj(v)){
            if(!visited[k])
                dfs(k);
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
