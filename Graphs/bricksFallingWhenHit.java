/*
	leetcode 803
	we can run bfs from each brick find the cnt of bricks which is are connnected to it 
	but the time complexity for this is equal to q * O(V + E);

	instead what we can do we can assume that all the query brick are already fallen and make set of all the 
	connected components (connecting all the adjacent bricks)
	then one by one connect query bricks and connect all the adjacent bricks and check the number of nodes increase in the set. 
	in this way we can process all the queries in o(1) time

	O(n * m) + o(hits.length);
*/

import java.util.*;
class bricksFallingWhenHit{
	static int[] par;
	static int[] size;

	public static int find(int x){
		if(par[x] == x){
			return x;
		}
		int temp = find(par[x]);
		par[x] = temp;
		return temp;
	}

	//always making lx as parent
	public static void union(int x, int y){
		int lx = find(x);
		int ly = find(y);

		if(lx != ly){
			if(lx == 0){
				par[ly] = lx;
				size[lx] += size[ly];
			}
			else if(ly == 0){
				par[lx] = ly;
				size[ly] += size[lx];
			}
			else{
				par[lx] = ly;
				size[ly] += size[lx];
			}
		}
	}

	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	public static void unionAdjacentCells(int i, int j, int[][] grid){
		int n = grid.length;
		int m = grid[0].length;
		int c1 = i * m + j + 1;  //2d to 1d (1 based indexed if we are following 0 based then 1 is not added)
		for(int[] d : dirs){
			int x = i + d[0];
			int y = j + d[1];

			if(x < 0 || x >= n || y < 0 || y >= m){
				continue;
			}
			if(grid[x][y] == 1){
				int c2 = x * m + y + 1;
				union(c1, c2);
			}
		}
		if(i == 0) union(0, c1); // Connect to the top of the grid.	
	}
	public int[] hitBricks(int[][] grid, int[][] hits) {
        //here we are making a dummy node zero for combining all the bricks connected to the first row directly or indirectly 
        int n = grid.length;
        int m = grid[0].length;
        par = new int[n * m + 1];
        size = new int[n * m + 1];

        for(int i = 0; i < n * m + 1; i++){
        	par[i] = i;
        	size[i] = 1;
        }

        //removing the query bricks
        for(int[] x : hits){
        	int r = x[0];
        	int c = x[1];
        	if(grid[r][c] == 1)
        		grid[r][c] = 2;
        }

        //combining the adjacent bricks
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(grid[i][j] == 1){
        			unionAdjacentCells(i, j, grid);
        		}
        	}
        }

        int prev = size[0];
        int[] ans = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; i--){
        	int r = hits[i][0];
        	int c = hits[i][1];

        	if(grid[r][c] == 2){
        		grid[r][c] = 1;
        		unionAdjacentCells(r, c, grid);
        		int cur = size[0];

        		// why minus 1 because excluding the brick that is dropped and
        		// why using max for edge case if after exluding the brick no
        		// brick has fallen than this will give the answer -1 to the query
        		ans[i] = Math.max(cur - prev - 1, 0);
        		prev = cur; 
        	}
        }
        return ans;
    }
}