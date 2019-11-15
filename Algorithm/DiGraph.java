package com.java.algo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DiGraph {

    List arr[] ,rev_arr[];
    boolean visited[],rev_visited[];
    int N=10,connected[];
    Stack<Integer> reverse_postorder = new Stack<>();



    DiGraph(){
        arr = new ArrayList[N];
        rev_arr = new ArrayList[N];
        visited =new  boolean[N];
        rev_visited =new  boolean[N];
        connected =new int[N];
        for(int i=0;i< arr.length;i++){
            visited[i]=false;
            rev_visited[i]=false;
            arr[i]=new ArrayList<Integer>();
            rev_arr[i]=new ArrayList<Integer>();
            connected[i]=i;
        }


    }

    public static void main(String ... ar){
        DiGraph graph = new DiGraph();
        graph.addNode(1,3);
        graph.addNode(5,1);
        graph.addNode(1,8);
        graph.addNode(3,6);
        graph.addNode(9,3);
        graph.addNode(8,4);
        graph.addNode(6,0);
        graph.addNode(6,7);
        graph.addNode(6,2);
        graph.addNode(3,5);


       /* int j=0;

        for(int i=0;i<10;i++){
            if(!graph.visited[i])
                graph.dfs(i,j++);
        }*/

        //graph.dfs(1,1);

      /*  for(int i=0;i<10;i++)
            graph.visited[i]=false;
        System.out.println();*/
       /* for(int i=0;i<10;i++)
            System.out.print("==>"+graph.connected[i]);

        System.out.println(graph.isConnected(1,3));
        System.out.println(graph.isConnected(2,9));
*/

               /* graph.topological(1);*/

        for(int i=0;i<10;i++){
            if(!graph.rev_visited[i])
                graph.reverse_dfs(i);
        }

        System.out.println();
        int j=0;
        while(!graph.reverse_postorder.isEmpty()){
                int v= Integer.parseInt(graph.reverse_postorder.pop().toString());
                if(!graph.visited[v]){

                    graph.dfs(v,j++);
                }

        }

        for(int i=0;i<10;i++)
            System.out.print("==>"+graph.connected[i]);


    }

    private boolean isConnected(int v,int w){
        return connected[v]==connected[w];
    }

    private void addNode(int v, int k){
        arr[v].add(k);
        rev_arr[k].add(v);
    }

    private List<Integer> adj(int v){
        return arr[v];
    }

    private List<Integer> rev_adj(int v){
        return rev_arr[v];
    }

    private void dfs(int v,int l){
        visited[v]=true;
        connected[v]=l;
        System.out.println("==> Node:"+v+" Component: "+ l);
        for(int k:adj(v)){
            if(!visited[k])
                dfs(k,l);
        }
    }

    private void reverse_dfs(int v){
        rev_visited[v]=true;

        for(int k:rev_adj(v)){
            if(!rev_visited[k])
                reverse_dfs(k);
        }
        reverse_postorder.push(v);
    }

    private void topological(int v){
        visited[v]=true;

        for(int k:adj(v)){
            if(!visited[k])
                topological(k);
        }
        System.out.print("==>"+v);
    }


    private void bfs(int v){
        java.util.LinkedList<Integer> bfs = new LinkedList<>();
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
