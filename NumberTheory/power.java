/*
	modular arithetic
	m = 1_000_000_007 longest prime number inside range of int
	(a  + b) % m = (a % m + b % m) % m
	(a - b) % m = (a - b + m) % m
	(a * b) % m = (a % m  * b % m) % m
	(a / b) % m = (a * b ^ (m - 2)) % m (only valid when m is a prime number)
	(a ^ b % m) =  a is very big a % m
				   if b is very big b % (m - 1) (when m is prime number)
				  after this 2 opertions a and b comes under the range of integer then we can binary exponentiation	

*/

class power{
	static int mod = 1_000_000_007;
	public static long modMul(long a, long b){
		return (a % mod * b % mod) % mod;
	}
	public static long power(long a, long b){
		long res = 1;
		while(b > 0){
			if((b & 1) == 1){  //if number is odd
				res = modMul(res, a);
			}
			a = modMul(a , a);
			b >>= 1; // reducing the power of b by 2 
		}
		return res;
	}

	public static void solve(String a, String b){
		long first = 0, second = 0;
		for(int i = 0; i < a.length(); i++){
			int j = a.charAt(i) - '0';
			first = (first * 10 + j) % mod;
		}

		for(int i = 0; i < b.length(); i++){
			int j = b.charAt(i) - '0';
			second = (second * 10 + j) % (mod - 1);
		}
		System.out.println(power(first, second));
	}

	public static void main(String[] args) {
		String a = "1000";
		String b = "10000000";
		//find a power b
		solve(a, b);
	}
}