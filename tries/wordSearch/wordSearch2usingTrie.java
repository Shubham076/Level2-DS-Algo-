//O(m*n*4^wl) if word not found in the grid
/*
here trie is guiding where the dfs call should be made
*/
package wordSearch;
import java.util.*;
public class wordSearch2usingTrie {
    static class Node {
        Node[] childs;
        String s;

        Node() {
            childs = new Node[26];
        }
    }

    static Node root;

    wordSearch2usingTrie() {
        root = new Node();
    }

    void insert(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.childs[c - 'a'] == null) {
                cur.childs[c - 'a'] = new Node();
            }
            cur = cur.childs[c - 'a'];
        }
        cur.s = s;
    }

    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void dfs(int i, int j, Node root, char[][] arr, int[][] vis, List<String> ans) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || vis[i][j] == 1) {
            return;
        }

        // means trie does not contains the char we are looking for
        //it does not make any sense to continue in this path
        if (root.childs[arr[i][j] - 'a'] == null)
            return;

        Node child = root.childs[arr[i][j] - 'a'];
        if (child.s != null) {
            ans.add(child.s);
        }
        vis[i][j] = 1;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            dfs(ni, nj, child, arr, vis, ans);
        }
        vis[i][j] = 0;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        wordSearch2usingTrie t = new wordSearch2usingTrie();
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            t.insert(w);
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, root, board, new int[n][m], ans);
            }
        }
        return ans;
    }
}
