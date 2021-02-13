// 1. You are given a number N.
// 2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
// 3. You have to find the number of ways in which these chords can be drawn.
import java.util.*;
class circlesAndChords{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= n; i++){
			int left = 0; 
			int right = i - 1;
			while(right >= 0){
				dp[i] += dp[left] * dp[right];
				left++;
				right--;
			}
		}
		System.out.println(dp[n]);
	}
}