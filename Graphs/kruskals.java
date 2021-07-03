import java.util.*;
class kruskals{
	static class Pair implements Comparable<Pair>{
		int first;
		int second;
		int weight;

		public Pair(int first, int second, int weight){
			this.first = first;
			this.second = second;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o){
			return this.weight - o.weight;
		}

		@Override
		public String toString(){
			return this.first + " " + this.second + " " + this.weight;
		}
	}

//disjoint set class 
	static class dsu{
		private int[] rank;
		private int[] parent;

		public dsu(int v){
			rank = new int[v];
			parent = new int[v];
			for(int i = 0; i < v; i++){
				parent[i] = -1;
				rank[i] = 1;
			}
		}

		public int findSet(int i){
			if(parent[i] == -1){
				return i;
			}
			parent[i] = findSet(parent[i]);
			return parent[i];
		}

		public void unionSet(int x, int y){
			int s1 = findSet(x);
			int s2 = findSet(y);

			if(s1 != s2){
				if(rank[s1] < rank[s2]){
					parent[s1] = s2;
					rank[s2] += rank[s1];
				}
				else{
					parent[s2] = s1;
					rank[s1] += rank[s2];
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();
		int cost = 0;
		Pair[] edgeList = new Pair[e];
		for(int i = 0; i < e; i++){
			Pair p = new Pair(scn.nextInt(), scn.nextInt(), scn.nextInt());
			edgeList[i] = p;
		}

		dsu d = new dsu(v);
		Arrays.sort(edgeList);

		for(Pair p : edgeList){
			int i = p.first;
			int j = p.second;
			int weight = p.weight;

			if(d.findSet(i) != d.findSet(j)){
				System.out.println(p);
				d.unionSet(i, j);
				cost += weight;
			}
		}
		System.out.println("Minimum cost: " + cost);
	}
}