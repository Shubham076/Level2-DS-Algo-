class consecutiveNumberSum{
	//general eq for a consecutive sequence of length k starting from x whose sum is N
	// x + (x + 1) + (x + 2) + ----- + (x + (k - 1)) = N  //eq of ap with common diff 1;
	// kx + (1 + 2 + 3 + ----- + (k - 1)) = N 
	// kx + k* (k - 1) / 2 = N    //sum of first k - 1 terms = k*(k - 1) / 2;
	// if we are getting a integer val for a value of k means a sequence is possible
	// from above eq if  (N - k * (k - 1) / 2) % k == 0 means it is possible. and the seq starts from x upto k terms

	//upper limit of  k
	// kx = (N - k * (k - 1) / 2)
	//lhs is positive so rhs should also be positive
	// (N - k * (k - 1) / 2) > 0
	// N > k * (k - 1) / 2     // k * (k - 1)  approximately equals to k * k
	// 2 * N = K * K


	public static void printSeq(int k, int n){
		int v = (k * (k - 1)) / 2;
		int x = (n - v) / k;
		for(int j = 0; j < k; j++){
			System.out.print((x + j) + " ");
		}
		System.out.println();
	}
	public static int consecutiveNumbersSum(int n) {
		int cnt = 0;
		for(int k = 1; k * k < 2 * n; k++){
			int v = (k * (k - 1)) / 2;
			if((n - v) % k == 0){
				printSeq(k, n);
				cnt++;
			}
		}
		return cnt;        
    }
	public static void main(String[] args) {
		int n = 1000;
		System.out.println(consecutiveNumbersSum(n));
	}
}