/*
Killjee has recently read about superdromes. Superdromes are those numbers
which are palindromic in both binary and decimal representation.

The number represented in binary representation will be up to its most
significant bit which is 1.

For example, 2 will be represented as {10}, 6 will be represented as {110} and
so on.

Now killjee ask you to find number of Superdromes less than or equal to n for
given n.
*/

import java.util.*;
import java.io.*;

public class superdromes {

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
	public static double ceil(double a) {return Math.ceil(a);}
	public static double floor(double a) {return Math.floor(a);}
	public static double pow(double a , int b) {return Math.pow(a, b);}

	public static void main(String[] args) {
		int t = f.nextInt();
		precalculate();
		for (int i = 1; i <= t; i++) {
			// print("Case #" + i + ": ");
			solve();
		}
		out.close();
		err.close();
	}

	public static StringBuilder decimalToBinary(int n) {
		StringBuilder res = new StringBuilder("");
		int p = 1;
		while (n > 0) {
			int r = n % 2;
			n /= 2;
			res.append(r);
		}
		return res.reverse();
	}

	public static boolean isPalindrome(StringBuilder s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	static int[] arr = new int[1_000_001];
	public static void precalculate(){
		for (int i = 1; i <= 1_000_000; i++) {
			boolean temp1 = isPalindrome(new StringBuilder(i + ""));
			boolean temp2 = isPalindrome(decimalToBinary(i));
			if(temp1 && temp2){
				arr[i] = arr[i - 1] + 1;
			}
			else{
				arr[i] = arr[i - 1];
			}
		}
	}

	public static void solve() {
		int n = f.nextInt();
		println(arr[n]);
	}
}