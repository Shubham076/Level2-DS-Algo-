//leetcode 463
public class islandPerimeter {
    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int island_Perimeter(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt += 4; // 4 is the perimeter of the square

                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= m) {
                            continue;
                        }

                        if (grid[x][y] == 1) {
                            cnt -= 1;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
