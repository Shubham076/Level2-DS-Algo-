/*
leetcode 1001
we simply create a hashmap for storing all the positions of lamps
and create 4 hashmap to store positions in matrix are covered by the lamps
time complexity O(q + l)
*/
import java.util.*;
class gridIllumination {
	static HashMap<Integer, Integer> row;
	static HashMap<Integer, Integer> col;
	static HashMap<Integer, Integer> d1; //diagonal
	static HashMap<Integer, Integer> d2; //diagonal2
	static HashMap<Integer, Integer> cell;

	static int[][] dirs = {{1, 1}, {-1, -1}, {1, -1}, { -1, 1}, {1, 0}, { -1, 0}, {0, 1}, {0, -1}, {0, 0}};

	public static void print(){
        System.out.println(row);
        System.out.println(col);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(cell); 
        System.out.println(); 
    }

	//if we put a lamp at r,c storing which cells is going to illuminate by this lamp
	public static void addLamp(int r, int c, int n) {
		int cNo = r * n + c;  //2d to 1d mapping
		row.put(r, row.getOrDefault(r, 0) + 1);
		col.put(c, col.getOrDefault(c, 0) + 1);
		d1.put(r + c, d1.getOrDefault(r + c, 0) + 1);
		d2.put(r - c, d2.getOrDefault(r - c, 0) + 1);
		cell.put(cNo, 1);
	}

	public static boolean isIlluminated(int r, int c, int n){
		int cno = r * n + c;
		return (row.containsKey(r) || col.containsKey(c) || d1.containsKey(r + c) || d2.containsKey(r - c) || cell.containsKey(cno));
	}

	public static void remove(int k, HashMap<Integer, Integer> map){
		int v = map.getOrDefault(k, 0);  //if it is illuminated
		if(v > 1){
			map.put(k, v - 1);
		}
		else{
			map.remove(k);
		}
	}

	public static void removeNbr(int r, int c, int n){
		int cno = r * n + c;
		remove(r, row);
		remove(c, col);
		remove(r + c, d1);
		remove(r - c, d2);
		remove(cno, cell);
	}

	public static void removeLamp(int r, int c, int n){
		for(int[] dir: dirs){
			int x = r + dir[0];
			int y = c + dir[1];
			if(x < 0 || y < 0 || x >= n || y >= n){
				continue;
			}
			if(cell.getOrDefault(x * n + y, 0) > 0)  //if lamp is present at cell
				removeNbr(x, y, n);
		}
	}
	public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		row = new HashMap<>();
		col = new HashMap<>();
		d1 = new HashMap<>();
		d2 = new HashMap<>();
		cell = new HashMap<>();
		int[] ans = new int[queries.length];

		for (int[] l : lamps) {
			int r = l[0];
			int c = l[1];
			if(cell.getOrDefault(r * n + c, 0) == 0)  //avoiding duplicate lamps
				addLamp(r, c ,n);
		}

		for(int i = 0; i < queries.length; i++){
			int r = queries[i][0];
			int c = queries[i][1];
			if(isIlluminated(r, c, n)){
				ans[i] = 1;
				removeLamp(r, c, n);
			}
			else{
				ans[i] = 0;
			}
		}
		return ans;
	}
}