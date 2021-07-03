//leetcode 1034
class coloringABorder{
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int curColor;
	public static boolean isValid(int i, int j, int[][] grid, int[][] visited){
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
			return false;
		}
		return true;
	}
	public static void dfs(int[][] grid, int r, int c, int color, int[][] visited){
		int cnt = 0;
		visited[r][c] = 1;
		for(int[] dir: dirs){
			int x = r + dir[0];
			int y = c + dir[1];

			if(isValid(x, y, grid, visited)){
				if(visited[x][y] == 1){
					cnt++;
				}
				else if(grid[x][y] == curColor){
					cnt++;
					dfs(grid, x, y, color, visited);
				}
			}
		}
		if(cnt != 4){
			grid[r][c] = color; 
		}
	}
	public static int[][] colorBorder(int[][] grid, int r, int c, int color) {
     	int n = grid.length;
     	int m = grid[0].length;
     	curColor = grid[r][c];
     	int[][] visited = new int[n][m];
     	dfs(grid, r, c, color, visited);
     	return grid;
    }
	public static void main(String[] args){
		int[][] arr = {{1, 1}, {1, 2}};
		colorBorder(arr, 0, 0, 3);
		for(int[] i: arr){
			System.out.println(i[0] + " "+ i[1]);
		}
	}
}