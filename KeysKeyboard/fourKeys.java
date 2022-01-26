/*
lintcode 867
Imagine you have a special keyboard with the following keys:

Key 1: (A): Print one 'A' on screen.
Key 2: (Ctrl-A): Select the whole screen.
Key 3: (Ctrl-C): Copy selection to buffer.
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
Now, you can only press the keyboard for N times (with the above four keys), find out the maximum 
numbers of 'A' you can print on screen.

for n <= 6  ans = n;

for performing a paste operation we need min 2 keys select, copy, paste
for n = 7 we have multiple options
case 1: we press key 1 -> 7 times = 7A
case 2: we press key 1 -> 4 times + (2, 3, 4) => f(4) + f(4) => 2 * f(4) => 8
case 3: we press key 1 -> 3 times + (2, 3, 4) + 4 => f(3) + f(3) + f(3) => 3 * f(3) => 9
case 4: we press key 1 -> 2 times + (2, 3, 4) + 4 + 4 => f(2) + f(2) + f(2) + f(2) => 4 * f(2) => 8
f(7) => max(case1, 2, 3,4)
O(N * (N - 3)) 
*/
class fourKeys{
	public static int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for(int i = 1; i <= N; i++){

        	//case 1
        	dp[i] = 1 + dp[i - 1];
        	int m = 2;
        	for(int j = i - 3; j >= 1; j--){
        		dp[i] = Math.max(dp[i], m * dp[j >= 0 ? j : 0]);
        		m++;
        	}
        }
        return dp[N];
    }
	public static void main(String[] args){
		int n = 7;
		System.out.println(maxA(n));
	}
}