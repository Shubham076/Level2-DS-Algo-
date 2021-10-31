import java.util.*;
// ques = print the min number of operations to covert source string to destination string
// by using insert delete and update operation
// here dp[i - 1][j - 1] represents replace operation
// dp[i - 1][j] represents delete operation
// dp[i][j - 1] represents insert operation
class levenshteinDistance{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = "shubham";
		String d = "shivani";
		int[][] dp = new int[s.length() + 1][d.length() + 1];

		for(int i = 0; i <= s.length(); i++){
			for(int j = 0; j <= d.length(); j++){

				// base cases 
				if(i == 0 && j== 0){
					dp[i][j] = 0;
				}
				else if(i == 0){
					dp[i][j] = j;
				}
				else if(j == 0){
					dp[i][j] = i; 
				}
				else{
					char c1 = s.charAt(i - 1);
					char c2 = d.charAt(j - 1);
					if(c1 == c2){
						dp[i][j] = dp[i - 1][j - 1];
					}
					else{
						dp[i][j] = 1 + Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j] , dp[i][j - 1]));
					}
				}
			}
		}

		System.out.print("  ");
		for(int j = 0; j < dp[0].length; j++){
			System.out.print(j > 0 ? d.charAt(j - 1) + " " : "- ");
		}
		System.out.println();

		for(int i = 0; i < dp.length; i++){
			System.out.print(i > 0 ? s.charAt(i - 1)+" " : "- ");
			for(int j = 0; j < dp[0].length; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Min edit distance is : " + dp[s.length()][d.length()]);
	} 
}