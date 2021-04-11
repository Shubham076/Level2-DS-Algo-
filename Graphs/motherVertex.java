import java.io.*;
import java.util.*;
class motherVertex{
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int v = Integer.parseInt(st[0]);
		int e = Integer.parseInt(st[1]);
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(v);

		for (int i = 0; i < v; i++) {
			graph.add(i, new ArrayList<>());
		}

		for(int i = 0; i < e; i++){
			st = br.readLine().split(" ");
			int s = Integer.parseInt(st[0]) - 1;
			int d = Integer.parseInt(st[1]) - 1;
			graph.get(s).add(d);
		}
		int[] visisted = new int[v];
		ArrayList<Integer> stack = new ArrayList<>();
		for(int i = 0; i < v; i++){
			if(visisted[i] == 0)
				dfs(graph, i, visisted, stack);
		}

		Arrays.fill(visisted, 0);
		count = 0;
		checkVertex(graph, stack.get(stack.size() - 1), visisted);
		if(count == v){
			System.out.println((stack.get(stack.size() - 1) + 1));
		}
		else{
			System.out.println(-1);
		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> g, int src,
	 int[] visisted, ArrayList<Integer> st){
		visisted[src] = 1;
		for(int nbr : g.get(src)){
			if(visisted[nbr] == 0){
				dfs(g, nbr,visisted, st);
			}
		}
		st.add(src);
	}

	public static void checkVertex(ArrayList<ArrayList<Integer>> g, int src,
	 int[] visisted){
		visisted[src] = 1;
		count++;
		for(int nbr : g.get(src)){
			if(visisted[nbr] == 0){
				checkVertex(g, nbr,visisted);
			}
		}
	}
}