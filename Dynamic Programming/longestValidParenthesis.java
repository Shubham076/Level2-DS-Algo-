class longestValidParenthesis{
	public static void main(String[] args){
		String s = "()))()";
		char[] c = s.toCharArray();
		int[] dp = new int[s.length()];
		int max = 0;
		for(int i = 1; i < c.length; i++){
			if(c[i] == ')'){

				// check for the previous character in the string if it is open then its a pair
				if(c[i - 1] == '('){
					dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
				}

                // check first character before the pair to immediate left of closing bracket	
				//for case (())
				else if(i - dp[i - 1] >= 1 && c[i - dp[i - 1] - 1] == '('){
					dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
				}
			}

			if(dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}
}