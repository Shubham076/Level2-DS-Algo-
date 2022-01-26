/*
leetcode 1514
use dikstra with max heap
*/
import java.util.*;
class pathWithMaximumProbability{
    static class Edge{
        int d;
        Double p;
        Edge(int d, Double p){
            this.d = d;
            this.p = p;
        }
    }
    static class Pair{
        int n;
        double p;
        Pair(int n, double p){
            this.n = n;
            this.p = p;
        }
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<Edge>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges.length; i++){
            int s = edges[i][0];
            int d = edges[i][1];
            g[s].add(new Edge(d, succProb[i]));
            g[d].add(new Edge(s, succProb[i]));
        }
        Queue<Pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.p, a.p));
        q.add(new Pair(start, 1.0));
        int[] vis = new int[n];
        
        while(q.size() > 0){
            Pair rm = q.remove();
            if(rm.n == end){
                return rm.p;
            }

            if(vis[rm.n] == 1) continue;
            vis[rm.n] = 1;

            for(Edge e: g[rm.n]){
                if(vis[e.d] == 0){
                    q.add(new Pair(e.d, rm.p * e.p));
                }
            }
        }
        return 0D;
    }
    public static void main(String[] args){
        int[][] edges= {{0, 1}, {1, 2}, {0, 2}};
        double[] p = {0.5, 0.5, 0.2};
        System.out.println(maxProbability(edges.length, edges, p, 0, 2));
    }
}