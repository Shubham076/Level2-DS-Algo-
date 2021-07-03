/*
possible for only directed and acyclic graph
topological sort => linear ordering such that for all u -> v u must appear before v;
order of compilation is the reverse of topological sort
*/

import java.io.*;
import java.util.*;

public class orderOfCompilationTopologicalSort {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      int vtces = 6;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int e = 6;
      int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
      for (int i = 0; i < edges.length; i++) {
         int v1 = edges[i][0];
         int v2 = edges[i][1];
         graph[v1].add(new Edge(v1, v2));
      }

      // write your code here
      Stack<Integer> s = new Stack<>();
      boolean[] visited = new boolean[vtces];
      
      for(int  i = 0; i < vtces; i++){
          if(!visited[i]){
              topologicalSort(graph , i , visited , s);
          }
      }
      
       while(!s.isEmpty()){
       System.out.print(s.pop() + " ");
   }   
}
   
   public static void topologicalSort(ArrayList<Edge>[] graph , int src , boolean[] visited , Stack<Integer> s){
       visited[src]  = true;
       for(Edge e : graph[src]){
           if(!visited[e.nbr]){
               topologicalSort(graph, e.nbr, visited, s);
           }
       }
       s.push(src);
   }
}