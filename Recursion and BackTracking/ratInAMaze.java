public class ratInAMaze {

    // rat can only move in forward and downward direction
    public static void printPath(String[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solve(String[][] maze, int r, int c, int cnt) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c].equals("1")) {
            return;
        }

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            maze[r][c] = "R";
            printPath(maze);
            cnt++;
            maze[r][c] = "0";
            return;
        }

        maze[r][c] = "R";
        solve(maze, r, c + 1, cnt);
        solve(maze, r + 1, c, cnt);
        maze[r][c] = "0";
    }

    static int cnt;

    public static void main(String[] args) {
        // -0 means dead ends
        String[][] maze = { { "0", "0", "0", "1", "0", "0" }, 
                            { "0", "1", "0", "0", "1", "0" },
                            {"0", "0", "1", "0", "0", "0"},
                            { "0", "0", "0", "1", "1", "0"},
                            { "0", "1", "0", "0", "0", "0" } };
        cnt = 0;
        solve(maze, 0, 0, cnt);
        System.out.println(cnt);
    }
}
