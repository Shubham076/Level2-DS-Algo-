import java.util.*;
class minimumPalindromeCut{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		boolean[][] storage = new boolean[s.length()][s.length()];
		int[] dp = new int[s.length()];

		for(int gap = 0; gap < s.length(); gap++){
			for(int i = 0, j = gap; j < s.length(); j++, i++){
				if(gap == 0){
					storage[i][j] = true;
				}
				else if(gap == 1){
					storage[i][j] = s.charAt(i) == s.charAt(j);
				}
				else{
					storage[i][j] = s.charAt(i) == s.charAt(j) && storage[i + 1][j - 1];
				}
			}
		}

		dp[0] = 0;

		for(int j = 1; j < s.length(); j++){

			// checking if the entire string is palindrome
			// if it is already palindrome then cut = 0
			if(storage[0][j]){
				dp[j] = 0;
			}
			else{
				int min = Integer.MAX_VALUE;
				for(int i = j; i >= 1; i--){
					if(storage[i][j]){
						if(dp[i - 1] < min){
							min = dp[i - 1];
						}
					}
				}
				dp[j] = 1 + min;
			}
		}

		for(int i : dp){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(dp[s.length() - 1]);
	}
}