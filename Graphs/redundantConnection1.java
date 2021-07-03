/*leetcode 684
*/
class redundantConnection1 {
	static int[] par;
	static int[] rank;
	static int find(int n){
		if(par[n] == n){
			return n;
		}
		int temp = find(par[n]);
		par[n] = temp;
		return temp;
	}

	public static void union(int x, int y){
		int lx = find(x);
		int ly = find(y);
		if(lx != ly){
			if(rank[lx] > rank[ly]){
				par[ly] = lx;
			}
			else if(rank[ly] > rank[lx]){
				par[lx] = ly;
			}
			else{
				par[lx] = ly;
				rank[ly]++;
			}
		}
	}
	public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
        	rank[i] = 1;
        	par[i] = i;
        }

        for(int[] e : edges){
        	int x = e[0] - 1;
        	int y = e[1] - 1;

        	if(find(x) != find(y)){
        		union(x, y);
        	}
        	else{
        		ans[0] = x + 1;
        		ans[1] = y + 1;
        		break;
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		int[][] arr = {{1, 2}, {1, 3}, {2, 3}};
		int[] ans = findRedundantConnection(arr);
		System.out.println(ans[0] + " " + ans[1]);
	}
}