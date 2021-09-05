//leetcode 741
public class cherryPickup {
    public static int countCherries(int r1, int c1, int r2, int c2, int[][] grid, int[][][][] dp){
        if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length
         || grid[r1][c1] == -1 || grid[r2][c2] == -1){
             return Integer.MIN_VALUE;
         }

         if(r1 == grid.length - 1 && c1 == grid[0].length - 1){
             return grid[r1][c1];
         }

         if(dp[r1][c1][r2][c2] != 0){
             return dp[r1][c1][r2][c2];
         }
         int cherries = 0;
         if(r1 == r2 && c1 == c2){
            cherries += grid[r1][c1];
         }
         else{ 
             cherries += grid[r1][c1] + grid[r2][c2]; 
         }

         int p1 = countCherries(r1 + 1, c1, r2 + 1, c2, grid, dp); //vv
         int p2 = countCherries(r1, c1 + 1, r2, c2 + 1, grid, dp); //hh
         int p3 = countCherries(r1 + 1, c1, r2, c2 + 1, grid, dp); //vh
         int p4 = countCherries(r1, c1 + 1, r2 + 1, c2, grid, dp); //hv

         cherries += Math.max(Math.max(p1, p2), Math.max(p3, p4));
         dp[r1][c1][r2][c2] = cherries;
         return cherries;
    }

    //as both person moving only one step so r1 + c2 == r2 + c2
    public static int countCherries2(int r1, int c1, int r2, int[][] grid, int[][][] dp){
        int c2 = r1 + c1 - r2;
        if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length
         || grid[r1][c1] == -1 || grid[r2][c2] == -1){
             return Integer.MIN_VALUE;
         }

         if(r1 == grid.length - 1 && c1 == grid[0].length - 1){
             return grid[r1][c1];
         }

         if(dp[r1][c1][r2] != 0){
             return dp[r1][c1][r2];
         }
         int cherries = 0;
         if(r1 == r2 && c1 == c2){
            cherries += grid[r1][c1];
         }
         else{ 
             cherries += grid[r1][c1] + grid[r2][c2]; 
         }

         int p1 = countCherries2(r1 + 1, c1, r2 + 1, grid, dp); //vv
         int p2 = countCherries2(r1, c1 + 1, r2, grid, dp); //hh
         int p3 = countCherries2(r1 + 1, c1, r2, grid, dp); //vh
         int p4 = countCherries2(r1, c1 + 1, r2 + 1, grid, dp); //hv

         cherries += Math.max(Math.max(p1, p2), Math.max(p3, p4));
         dp[r1][c1][r2] = cherries;
         return cherries;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        int ans = countCherries(0, 0, 0, 0, grid, dp);
        return ans > 0 ? ans : 0;
    }
}
