///leetcode 959

/*
reprsent each and every character by in the grid with a area and check if cycle in created . If it is created than increse cnt by 1;
*/
import java.util.*;
class cutBySlashes {
	static int[] par;
	static int[] rank;
	static int cnt;
	public static int find(int x) {
		if (par[x] == x) {
			return x;
		}
		int temp = find(par[x]);
		par[x] = temp;
		return temp;
	}

	public static void union(int x, int y) {
		int lx = find(x);
		int ly = find(y);

		if (lx != ly) {
			if (rank[lx] > rank[ly]) {
				par[ly] = lx;
			}
			else if (rank[ly] > rank[lx]) {
				par[lx] = ly;
			}
			else {
				par[lx] = ly;
				rank[ly]++;
			}
		} else {
			cnt++;
		}
	}
	public static int regionsBySlashes(String[] grid) {
		int n = grid.length;
		int dots = n + 1;
		par = new int[dots * dots];
		rank = new int[dots * dots];
		Arrays.fill(rank, 1);
		for(int i = 0; i < dots* dots; i++){
			par[i] = i;
		}
		cnt = 1;

		//connecting the bounbary
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0 || i == n || j == n) {
					int cell = i * dots + j;
					if (cell != 0) {
						union(0, cell);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char c = grid[i].charAt(j);

				if (c == '/') { //join (i + 1, j) and (1, j + 1);
					int c1 = (i + 1) * dots + j;
					int c2 = i * dots + (j + 1);
					union(c1, c2);
				} 
				else if (c == '\\') { //(i , j) and (i + 1),(j + 1)
					int c1 = i * dots + j;
					int c2 = (i + 1) * dots + (j + 1);
					union(c1, c2);
				}

			}
		}
		return cnt;
	}
}
public static void main(String[] args) {
	String[] arr = {" /", "/ "};
	System.out.println(regionsBySlashes(arr));
}
}