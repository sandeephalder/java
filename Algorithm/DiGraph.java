/*
package com.java.algo1;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiGraph {

    String line = "";
    int V, E;
    ArrayList[] list, reverse;
    boolean visited[];
    int edgeto[];
    ArrayList<Integer> reverseList = new ArrayList<>();



    DiGraph() throws IOException {
        File file = new File("C:\\Users\\haldes2\\Documents\\temp\\graph.txt");
        FileReader f_stream = new FileReader(file);
        BufferedReader reader = new BufferedReader(f_stream);
        V = new Integer(reader.readLine());
        E = new Integer(reader.readLine());
        list = new ArrayList[V + 1];
        reverse = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        edgeto = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList();
            reverse[i] = new ArrayList();
            visited[i] = false;
            edgeto[i] = i;
        }
        int src, dest;
        while ((line = reader.readLine()) != null) {
            src = new Integer(line.split(" ")[0]);
            dest = new Integer(line.split(" ")[1]);
            add(src, dest);
        }
        //print();
        //dfs(1); //==>1==>2==>9==>5==>4==>3==>6==>7==>8==>10
        //topologicalSort(1);//==>9==>2==>3==>4==>7==>10==>8==>6==>5
        for(int i=1;i<=V;i++)
            if(!visited[i])
                reversePostOrder(i);

        for (int i = 0; i <= V; i++)
            visited[i]=false;

        System.out.println(reverseList);
        int i=0;
        for(int v:reverseList)
        {

            if(!visited[v]){
                //System.out.println("Generation="+i++);
                dfs(v,i++);
            }

        }

    }

    public static void main(String... args) {
        try {
            DiGraph graph = new DiGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void add(int src, int dest) {
        //System.out.println(src + "=>" + dest);
        list[src].add(dest);
        reverse[dest].add(src);
    }

    private void print() {
        var i = 0;
        for (var li : list)
            System.out.println(i++ + "[==>]" + li);

    }

    private ArrayList adj(int src) {
        return list[src];
    }

    private ArrayList revAdj(int src) {
        return list[src];
    }


    private void dfs(int index,int i) {
        visited[index] = true;
        System.out.print("==>("+i+")" + index);
        for (Object obj : adj(index)) {
            int v = (Integer) obj;
            if (!visited[v])
                dfs(v,i);
        }
    }

    private void reversePostOrder(int src) {
        visited[src] = true;

        for (Object obj : revAdj(src)) {
            int v = (Integer) obj;
            if (!visited[v]) {
                reversePostOrder(v);

            }

        }
        reverseList.add(src);
    }

    private void bfs(int index) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        System.out.print("==>" + index);
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (Object obj : adj(v)) {
                int w = (Integer) obj;
                if (!visited[w]) {
                    queue.add(w);
                    System.out.print("==>" + w);
                    visited[w] = true;
                }
            }
        }

    }

    private void topologicalSort(int index) {
        visited[index] = true;
        for (var obj : adj(index)) {
            int v = (Integer) obj;
            if (!visited[v]) {
                topologicalSort(v);
                System.out.print("==>" + v);
            }
        }
    }
}
*/
