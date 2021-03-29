import java.util.*;
class bellmanFord{
	static int[] distances;
	static boolean negativeCycle = false;
	public static void solve(ArrayList<ArrayList<Integer>> graph){
		for(int i = 0; i < distances.length - 1; i++){
			for(ArrayList<Integer> e : graph){
				int u = e.get(0);
				int v = e.get(1);
				int w = e.get(2);
				if(distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v]){
					distances[v] = distances[u] + w;
				}
			}
		}

		for(ArrayList<Integer> e : graph){
				int u = e.get(0);
				int v = e.get(1);
				int w = e.get(2);
				if(distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v]){
					System.out.println("Negative weight cycle found!");
					negativeCycle = true;
					break;

				}
			}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int e = scn.nextInt();
		for(int i = 0; i < e; i++){
			ArrayList<Integer> edge = new ArrayList<>();
			edge.add(scn.nextInt());
			edge.add(scn.nextInt());
			edge.add(scn.nextInt());
			graph.add(edge);
		}
		distances = new int[graph.size()];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;
		solve(graph);
		if(!negativeCycle){
			for(int i = 0; i < distances.length; i++){
			System.out.println("Node" + i + ": " + distances[i]);
			}
		}
	}
}