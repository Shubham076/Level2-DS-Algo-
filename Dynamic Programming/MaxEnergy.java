/*

given 4 by 4 matrix initial energy = 100 task is to reach last row of matrix with max
energy possible matrix can be traversed in following way (i+1,j) (i+1, j-1), (i+1)(j+1),
you can start with any cell and finish traversal in last row . after stepping on cell (i, j)
energy decreases by mat[i][j] units Find max energy. final energy can be negative
 */
import java.util.*;
import java.io.*;
class MaxEnergy {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{4, 6, 16, 21}, {17, 0, 5, 5}, {4, 41, 22, 3}, {2, 51, 6, 0}};
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];
        int in = 100;

        // Initialize dp with energy after reaching cells in the last row
        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = in - arr[n - 1][j];
        }

        // Fill the dp table
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                // Get the maximum energy from the three possible moves
                int maxEnergy = Integer.MIN_VALUE;
                for (int k = -1; k <= 1; k++) {
                    if (j + k >= 0 && j + k < m) {
                        maxEnergy = Math.max(maxEnergy, dp[i + 1][j + k]);
                    }
                }
                dp[i][j] = maxEnergy - arr[i][j];
            }
        }

        // Find the maximum energy in the first row
        int maxEnergy = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxEnergy = Math.max(maxEnergy, dp[0][j]);
        }

        System.out.println(maxEnergy);
    }
}
