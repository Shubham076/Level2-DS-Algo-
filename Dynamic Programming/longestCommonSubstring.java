import java.util.*;
class longestCommonSubstring{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int[][]dp = new int[s1.length() + 1][s2.length() + 1];
		int max = Integer.MIN_VALUE;

		for(int i = 1; i < s1.length(); i++){
			for(int j = 1; j < s2.length(); j++){
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				if(c1 == c2){
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				else{
					dp[i][j] = 0;
				}

				if(dp[i][j] > max){
					max = dp[i][j];
				}
			}
		}

		System.out.println("Longest Common Substring is : " + max);
	}
}