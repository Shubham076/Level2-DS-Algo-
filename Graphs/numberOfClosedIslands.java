/*
leetcode 1254
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected 
group of 0s and a closed island is an island
totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
*/
public class numberOfClosedIslands {
    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
            return;
        
        grid[i][j] = 1; // making water
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            dfs(grid, x, y);
        }
    }

    // 2 traversal of grid
    public int closedIsland1(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    if (grid[i][j] == 0) { // land connected to the boundary
                        dfs(grid, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    static int dfs2(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            //can't be considered as closed island as it is touching boundary
            return 0;
        }
        if (grid[i][j] == 1){
            //means surrounded by water
            return 1;  
        } 

        grid[i][j] = 1; // making water
        int ans = 1;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            ans = (ans & dfs2(grid, x, y));  //if any time we meets boundary dfs return 0 and ans becomes 0
        }
        return ans;
    } 

    // 1 traversal of grid
    public int closedIsland2(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) { 
                        cnt += dfs2(grid, i, j);
                }
            }
        }
        return cnt;
    }
}
