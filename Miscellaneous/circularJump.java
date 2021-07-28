/*
There are N chairs arranged around a circular table. Each chair has a number
written on it. Any person sitting on a chair i can jump  number of indices
towards left or right, You are sitting on chair X and you have to reach chair
Y. Tell the minimum number of jumps required by you. If its impossible to
reach then print 1.

Example :- If your sitting on chair 4 and it has number 2 written on it then
you can either jump to chair number 2 or chair number 6.
1
5 1 5
2 1 2 3 4

output 2
*/

import java.util.*;
import java.io.*;
public class circularJump {

	static int int_max = Integer.MAX_VALUE;
	static int int_min = Integer.MIN_VALUE;

	private static final Scanner scn = new Scanner(System.in);
	private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void print(Object o) {out.print(o);}
	public static void println(Object o) {out.println(o);}
	public static void println() {out.println();}

	public static void main(String[] args) {
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			// print("Case #" + i + ": ");
			solve();
		}
		out.close();
	}
	public static void solve() {
		int n = scn.nextInt();
		int x = scn.nextInt() - 1; //for making zero based
		int y = scn.nextInt() - 1;
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, 0});  //index ,  initial steps

		while (q.size() > 0) {
			int[] rp = q.remove();

			if(visited[rp[0]]) continue;
			else visited[rp[0]] = true;
			
			if (rp[0] == y) {
				println(rp[1]);
				return;
			}

			int nf = (rp[0] + arr[rp[0]]) % n; //forward
			int np = (rp[0] - arr[rp[0]]) % n; //backward
			if(np < 0){
				np += n;
			}			
			if(!visited[nf]){
				q.add(new int[] {nf, rp[1] + 1});
			}

			if(!visited[np]){
				q.add(new int[] {np, rp[1] + 1});
			}
		}
		println(-1);
	}
}