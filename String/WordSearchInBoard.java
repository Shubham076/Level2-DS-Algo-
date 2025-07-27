//leetcode 74
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
public class WordSearchInBoard {
    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)){
                    visited = new int[n][m];
                    if(search(board, visited, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] arr, int[][] visited, String word, int i, int j, int idx) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == 1
        || arr[i][j] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        visited[i][j] = 1;
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            boolean found = search(arr, visited, word, ni, nj, idx + 1);
            if (found)
                return true;
        }
        visited[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(arr, word));
    }
}
