class euclideanGCD {
	public static void main(String[] args) {
		int n = 18;
		int m = 7;
		System.out.println(gcd1(n, m));
		System.out.println(gcd2(n, m));
	}
// O(logN) recursion
	public static int gcd1(int a, int b) {
		return b == 0 ? a : gcd1(b, a % b);
	}

	//iterative
	public static int gcd2(int a, int b) {
		int divisor = a;
		int dividend = b;

		while (dividend % divisor != 0) {
			int r = dividend % divisor;
			dividend = divisor;
			divisor = r;
		}
		return divisor;
	}
}