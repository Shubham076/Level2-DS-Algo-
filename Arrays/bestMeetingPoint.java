// lintcode 912
import java.util.*;
class bestMeetingPoint {
	public static int distance(int x1, int y1, int x2, int y2){
		int ans = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		return ans;
	}
	public static int minTotalDistance(int[][] grid) {
		// Write your code here
		ArrayList<Integer> x = new ArrayList<>();   //travelling across columns
		ArrayList<Integer> y = new ArrayList<>();   // trvaelling across rows
		//travelling in a row
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					y.add(i);
				}
			}
		}

		//travelling in column
		for(int j = 0; j < grid[0].length; j++){
			for(int i = 0; i < grid.length; i++){
				if(grid[i][j] == 1){
					x.add(j);
				}
			}
		}

		int mx = x.get(x.size() / 2);
		int my = y.get(y.size() / 2);
		int d = 0;

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					d += distance(j, i, mx, my);
				}
			}
		}

		return d;
	}

	public static void main(String[] args) {
		int[][] arr = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
		System.out.println(minTotalDistance(arr));
	}
}