//leetcode 1129 shortest path with alternating colors
import java.util.*;
class shortestPathWithAlternatingColors{
    static class Edge{
        int v;
        int c;
        Edge(int v, int c){
            this.v = v;
            this.c = c;
        }

        @Override
        public String toString(){
            return "(" + this.v + " " + this.c + ")";
        }
    }
    public static void main(String[] args){
        int n = 5;
        int[][] red = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blue = {{1, 2}, {2, 3}, {3, 1}};
        HashMap<Integer, HashSet<Edge>> g = new HashMap<>();
        
        /*
        shortest path ending with red or blue edge
        why we need a 2d array beacuse it can be possible that
        we cant reach a vertex with a particular color 
        but we can reach with a diff color
        and answer is equal to min of length from both color
        */
        int[][] paths = new int[n][2];
        for(int[] a: paths){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        paths[0][0] = paths[0][1] = 0;

        //Edges are added in the queue;
        Queue<Edge> q = new ArrayDeque<>();
        q.add(new Edge(0, 1));
        q.add(new Edge(0, 0));
        
        for(int[] r: red){
            int s = r[0];
            int d = r[1];
            g.putIfAbsent(s, new HashSet<>());
            g.get(s).add(new Edge(d, 0));
        }

        for(int[] b: blue){
            int s = b[0];
            int d = b[1];
            g.putIfAbsent(s, new HashSet<>());
            g.get(s).add(new Edge(d, 1));
        }

        System.out.println(g);
        while(q.size() > 0){
            Edge rm = q.remove();
            
            for(Edge e: g.getOrDefault(rm.v, new HashSet<>())){
                
                //alternating colors
                if((rm.c ^ e.c) > 0){
                    if(1 + paths[rm.v][rm.c] < paths[e.v][e.c]){
                        paths[e.v][e.c] = 1 + paths[rm.v][rm.c];
                        q.add(new Edge(e.v, e.c));
                    }
                }
            }
        }
        int[] ans = new int[n];
        for(int i = 0; i < ans.length; i++){
            int a = Math.min(paths[i][0], paths[i][1]);
            if(a == Integer.MAX_VALUE){
                ans[i] = -1;
            }
            else 
                ans[i] = a;
        }
        for(int v: ans){
            System.out.print(v + " ");
        }
    }
}