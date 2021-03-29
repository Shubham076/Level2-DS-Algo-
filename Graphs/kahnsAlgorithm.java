import java.util.*;
class kahnsAlgorithm{

	public static void print(int[] arr){
		for(int i : arr){
				System.out.print(i + " ");
			}
			System.out.println();
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < e; i++){
			graph.add(i, new ArrayList<>());
		}

		for(int i = 0; i < e; i++){
			int a = scn.nextInt();
			int b = scn.nextInt();
			graph.get(b).add(a);
		}
		// System.out.println(graph);
		int[] indeg = new int[v];
		int[] ans = new int[v];
		int idx = 0;
		Queue<Integer> q = new ArrayDeque<>();

		// calculate indegree of each vertex
		for(int i = 0; i < v; i++){
			for(int nbr : graph.get(i)){
				indeg[nbr]++;
			}
		}

		//add in the queue whose indegree is 0;
		for(int i = 0; i < v; i++){
			if(indeg[i] == 0){
				q.add(i);
			}
		}


		while(q.size() > 0){
			int r = q.remove();
			ans[idx] = r;
			idx++;

			//add all the nbrs and decrease their indegree
			for(int nbr : graph.get(r)){
				indeg[nbr]--;

				if(indeg[nbr] == 0){
					q.add(nbr);
				}
			}
		}
		if(idx == v){
			print(ans);
		}
		else{
			return;
		}
	}
}