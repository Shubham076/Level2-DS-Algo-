import java.util.*;
//time complexity of dfs(v + e);
//finding the strongly connected components of a graph
class kosarajuAlgo{
	static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void printGraph(ArrayList<Edge>[] g){
    	for(ArrayList<Edge> l : g){
    		for(Edge e : l){
    			System.out.print(e);
    		}
    		System.out.println();
    	}
    }

    public static void dfs(int src, ArrayList<Edge>[] g, Boolean[] visited, ArrayList<Integer> order){
    	visited[src] = true;

    	for(Edge e : g[src]){
    		if(!visited[e.nbr]){
    			dfs(e.nbr, g, visited, order);
    		}
    	}
    	order.add(src);
    }

   	public static void dfs_reverse(int src, ArrayList<Edge>[] g, Boolean[] visited){
   		visited[src] = true;
   		System.out.print(src + " ");
    	for(Edge e : g[src]){
    		if(!visited[e.nbr]){
    			dfs_reverse(e.nbr, g, visited);
    		}
    	}
   	}

    public static void solve(ArrayList<Edge>[] g, ArrayList<Edge>[] rg , int n){
    	Boolean[] visited = new Boolean[n];
    	Arrays.fill(visited , false);
    	ArrayList<Integer> order = new ArrayList<>();


    	// step 1 :  call dfs on the main graph and fill the order array
    	for(int i = 0; i < n; i++){
    		if(!visited[i]){
    			dfs(i, g, visited, order);
    		}
    	}
    	Arrays.fill(visited , false);
    	char c = 'A';
    	// step 2 call dfs in the reverse order of (order array) in the reverse graph
    	for(int i = order.size() - 1; i >= 0; i--){
    		int m = order.get(i);
    		if(!visited[m]){
    			System.out.print(c + ": ");
    			dfs_reverse(m, rg, visited);
    			c++;
    			System.out.println();
    		}
    	}
    }

    public static void main(String[] args){
    	fastReader f = new fastReader();
    	int vtces = f.nextInt();
    	ArrayList<Edge>[] graph = new ArrayList[vtces];
    	ArrayList<Edge>[] rgraph = new ArrayList[vtces];
    	for(int i = 0; i < vtces; i++){
    		graph[i] = new ArrayList<Edge>();
    		rgraph[i] = new ArrayList<Edge>();   //reverse graph
    	}
    	int edges = f.nextInt();
    	for(int i = 0; i < edges; i++){
    		int src = f.nextInt();
    		int des = f.nextInt();
    		graph[src].add(new Edge(src, des));
    		rgraph[des].add(new Edge(des, src));

    	}
    	solve(graph, rgraph, vtces);
    }
}