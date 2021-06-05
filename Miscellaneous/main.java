import java.util.*;
import java.io.*;



//develoopingg



public class main {
	static Scanner scn = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	public static void print(Object o) {out.print(o);}
	public static void println(Object o) {out.println(o);}
	public static void println() {out.println();}

	public static void main(String[] args) {
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			cnt = 0;
			print("Case " +  i + ": ");
			solve();
		}
		out.close();
	}

	static int[][] dirs = {{1, 1}, { -1, -1}, { -1, 1}, {1, -1}, {0, 1}, {0, -1}, {1, 0}, { -1, 0}};
	static int cnt;

	public static void search(char[][] arr, String word, int i, int j) {
		int n = arr.length;
		int m = arr[0].length;
		if (arr[i][j] != word.charAt(0)) return;

		for (int[] d : dirs) {
			int ni = i + d[0];
			int nj = j + d[1];
			int k;
			for (k = 1; k < word.length(); k++) {
				if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
					break;
				}

				if (arr[ni][nj] != word.charAt(k)) {
					break;
				}

				ni += d[0];
				nj += d[1];
			}


			if (k == word.length()) {
				cnt++;
			}
		}
	}

	public static void solve() {
		int n = scn.nextInt();
		int m = scn.nextInt();
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = scn.next();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		String word = scn.next();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				search(arr, word, i, j);
			}
		}
		println(cnt);

	}
}