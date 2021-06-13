/*
The tycoon of a winery empire in Mondstadt, unmatched in every possible way. A
thinker in the Knights of Favonius with an exotic appearance.

This time, the brothers are dealing with a strange piece of wood marked with
their names. This plank of wood can be represented as a string of n
characters. Each character is either a 'D' or a 'K'. You want to make some
number of cuts (possibly 0) on this string, partitioning it into several
contiguous pieces, each with length at least 1. Both brothers act with
dignity, so they want to split the wood as evenly as possible. They want to
know the maximum number of pieces you can split the wood into such that the
ratios of the number of occurrences of 'D' to the number of occurrences
of 'K' in each chunk are the same.

Kaeya, the curious thinker, is interested in the solution for multiple
scenarios. He wants to know the answer for every prefix of the given string.
Help him to solve this problem!

For a string we define a ratio as a:b where 'D' appears in it a times, and 'K'
appears b times. Note that a or b can equal 0, but not both. Ratios a:b and
c:d are considered equal if and only if a⋅d=b⋅c.

For example, for the string 'DDD' the ratio will be 3:0, for 'DKD' — 2:1,
for 'DKK' — 1:2, and for 'KKKKDD' — 2:4. Note that the ratios of the latter
two strings are equal to each other, but they are not equal to the ratios of
the first two strings.

Input Each test contains multiple test cases. The first line contains the
number of test cases t (1≤t≤1000). Description of the test cases follows.

The first line of each test case contains an integer n (1≤n≤5⋅105) — the
length of the wood.

The second line of each test case contains a string s of length n. Every
character of s will be either 'D' or 'K'.

It is guaranteed that the sum of n over all test cases does not exceed 5⋅105.

Output For each test case, output n space separated integers. The i-th of
these numbers should equal the answer for the prefix s1,s2,…,si.

5
3
DDK
6
DDDDDD
4
DKDK
1
D
9
DKDKDDDDK
Output
1 2 1
1 2 3 4 5 6
1 1 1 2
1
1 1 1 2 1 2 1 1 3
*/
import java.util.*;
import java.io.*;

public class dilucAndkaeya {

	static class fastReader {
		BufferedReader br;
		StringTokenizer st;

		public fastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String Next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(Next());
		}

		float nextFloat() {
			return Float.parseFloat(Next());
		}

		boolean nextBoolean() {
			return Boolean.parseBoolean(Next());
		}

		double nextDouble() {
			return Double.parseDouble(Next());
		}

		long nextLong() {
			return Long.parseLong(Next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		String next() {
			return Next();
		}
	}
	static int int_max = Integer.MAX_VALUE;
	static int int_min = Integer.MIN_VALUE;

	private static final fastReader f = new fastReader();
	private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	private static final PrintWriter err = new PrintWriter(new BufferedOutputStream(System.err));

	public static void print(Object o) {out.print(o);}
	public static void println(Object o) {out.println(o);}
	public static void println() {out.println();}

	public static void debug(Object o) {err.print(o);}
	public static void debugln(Object o) {err.println(o);}
	public static void debugln() {err.println();}

	public static<T extends Comparable<T>> T max(T a , T b) {return a.compareTo(b) > 0 ? a : b;}
	public static<T extends Comparable<T>> T min(T a , T b) {return a.compareTo(b) > 0 ? b : a;}

	public static void main(String[] args) {
		int t = f.nextInt();
		for (int i = 1; i <= t; i++) {
			// print("Case #" + i + ": ");
			solve();
		}
		out.close();
		err.close();
	}

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void solve() {
		int n = f.nextInt();
		String s = f.next();
		int[] arr = new int[n];
		StringBuilder ans = new StringBuilder("");
		HashMap<String, Integer> map = new HashMap<>();
		int[] dcnt = new int[n];
		int[] kcnt = new int[n];
		if(s.charAt(0) == 'D'){
			dcnt[0] = 1;
		}
		else{
			kcnt[0] = 1;
		}
		for(int i = 1; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == 'D'){
				dcnt[i] = dcnt[i - 1] + 1;
				kcnt[i] = kcnt[i - 1]; 
			}
			else{
				dcnt[i] = dcnt[i - 1];
				kcnt[i] = kcnt[i - 1] + 1;
			}
		}
		map.put(dcnt[0] + "#" + kcnt[0], 1);
		for(int i = 1; i < s.length(); i++){
			int gcd = gcd(dcnt[i], kcnt[i]);
			String key = dcnt[i] / gcd + "#" + kcnt[i] / gcd;
			arr[i] = map.getOrDefault(key, 1);
			map.put(key, map.getOrDefault(key, 1) + 1);
		}
		for (int i : arr) {
			ans.append(i + " ");
		}
		println(ans);
	}
}