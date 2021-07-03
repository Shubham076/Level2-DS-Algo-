/*
https://practice.geeksforgeeks.org/problems/eulerian-path-in-an-undirected-graph5052/1
Eulerian Path is a path in graph that visits every edge exactly once.
Eulerian Circuit is an Eulerian Path which starts and ends on the same
vertex.

how to check whether graph contains eulerian circuit or not in case of undirected graph => if all the vertices have 
even number of nbrs or even degree
if graph contains eulerian circuit then it also contains eulerian path but the reverse is not true

how to check whether graph contains eulerian path or not in case of undirected graph => if exactly V - 2  vertices have 
even nbrs or degree then eulerian path is present
*/
class eulerianPathInUndirectedGraph{
	static int eulerPath(int N, int graph[][]){
        int n = graph.length;
        int[] degree = new int[n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		if(graph[i][j] == 1){
        			degree[i]++;
        		}
        	}
        }

        int cnt = 0;
        for(int i : degree){
        	if(i % 2 != 0){
        		cnt++;
        	}
        }

        return cnt == 2 ? 1 : 0;
    }
}