package com.java.algo1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    String line = "";
    int V, E;
    ArrayList[] list;
    boolean visited[];
    int edgeto[];


    Graph() throws IOException {
        File file = new File("C:\\Users\\haldes2\\Documents\\temp\\graph.txt");
        FileReader f_stream = new FileReader(file);
        BufferedReader reader = new BufferedReader(f_stream);
        V = new Integer(reader.readLine());
        E = new Integer(reader.readLine());
        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        edgeto = new int[V + 1];
        for (int i = 0; i <=V; i++) {
            list[i] = new ArrayList();
            visited[i] = false;
            edgeto[i]=i;
        }
        int src, dest;
        while ((line = reader.readLine()) != null) {
            src = new Integer(line.split(" ")[0]);
            dest = new Integer(line.split(" ")[1]);
            add(src, dest);
        }
        //print();
        bfs(1);
    }

    public static void main(String... args) {
        try {
            Graph graph = new Graph();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void add(int src, int dest) {
        System.out.println(src + "=>" + dest);
        list[src].add(dest);
        list[dest].add(src);
    }

/*    private void print() {
        var i=0;
        for(var li:list)
        System.out.println(i+++"[==>]"+li);

    }*/

    private ArrayList adj(int src){
        return list[src];
    }

    private void dfs(int index){
        visited[index]= true;
        System.out.print("==>"+index);
        for(Object obj:adj(index)){
            int v= (Integer)obj;
            if(!visited[v])
                dfs(v);
        }
    }

    private void bfs(int index){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index]=true;
        System.out.print("==>"+index);
        while (!queue.isEmpty()){
            int v = queue.removeFirst();
            for (Object obj :adj(v)){
                int w= (Integer)obj;
                if(!visited[w]){
                    queue.add(w);
                    System.out.print("==>"+w);
                    visited[w]=true;
                }
            }
        }

    }
}
