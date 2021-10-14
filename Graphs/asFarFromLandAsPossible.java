//leetcode 1162
/*
question is same as zero one matrix we have to find the max distance of zero from ones
so we use reverse bfs we start our bfs from ones
*/
import java.util.*;
class asFarFromLandAsPossible{
	static int[][] dirs = {{0, 1}, {0,  -1}, {1, 0}, {-1, 0}};
	public static int maxDistance(int[][] grid) {
		Queue<int[]> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(grid[i][j] == 1){
        			q.add(new int[] {i, j});
        		}
        		else{
        			grid[i][j] = Integer.MAX_VALUE;
        		}
        	}
        }

        // if all the cells are water or all the cells are land
        if(q.size() == 0 || q.size() == n * m){
        	return -1;
        }
        int max = Integer.MIN_VALUE;
        //bfs
        while(q.size() > 0){
        	int[] rm = q.remove();
        	int i = rm[0];
        	int j = rm[1];
        	for(int[] dir: dirs){
        		int x = i + dir[0];
        		int y = j + dir[1];

        		if(x < 0 || y < 0 || x >= n || y >= m || 1 + grid[i][j] > grid[x][y]){
        			continue;
        		}

        		grid[x][y] = 1 + grid[i][j];
        		max = Math.max(max, grid[x][y]);
        		q.add(new int[] {x, y});
        	}
        }
        return max - 1;
        /*why minus 1 because we are adding one in the queue so when we 1 + grid[i][j] => grid[i][j] contains value 1
			in case of zero one matrix we are adding zeros in the queue so it doesnt affect
		*/
    }	
	public static void main(String[] args) {
		int[][] arr = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
		maxDistance(arr);
		// for(int[] a : arr){
		// 	System.out.println(a[0] + " " + a[1] + " " + a[2]);
		// }
	}
}