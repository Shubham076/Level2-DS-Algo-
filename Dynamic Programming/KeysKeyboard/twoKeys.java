/*
leetcode 650
As per the keyboard operations:
to get AA from A we need 2 additional steps (copy-all and then paste)
to get AAA from A we need 3 additional steps (copy-all, then paste, then again paste)

For generating AAAA we need 2 additional steps from AA.
however, to get AAAAAAAA, the most optimal way would be from AAAA, with 2 additional steps (copy-all then paste)
Essentially, we find the next smaller length sequence (than the one under consideration) which can be copied
and then pasted over multiple times to generate the desired sequence. The moment we find a length that divides
our required sequence length perfectly, then we don't need to check for any smaller length sequences.

eg 6:
first factor dividing 6 => 6 % 3 == 0 => means we need 2 3A's => cost = 2 (copy all and paste one time)
cost of one 3As => 3
ans = 3 + 2 => 5
*/
class twoKeys{

	//O(n * n)
	public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        //dp[0] = dp[1] = 0 as single A is present in notepad we dont need any cost
        for(int i = 2; i <= n; i++){
        	for(int j = i - 1; j >= 1; j--){
        		if(i % j == 0){
        			/*	
						i = 4 means we need to generate AAAA
						so we check smallest fact that divides i here is this case j = 2
						so total op = op(2) + 1copy + 1paste => op(2) + (i / j);
        			*/
        			dp[i] = dp[j] + (i / j);
        			break;
        		}
        	}
        }
        return dp[n];
    }
	public static void main(String[] args){
		int n = 3;
		System.out.println(minSteps(n));
	}
}