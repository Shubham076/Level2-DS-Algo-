/* basically this problem want certainity that after dropping e eggs we found the critical flooe
or we can say that we want to find min of the max
2 cases:
case1:  if egg break at kth floor thenwe have to (k - 1) floor with e - 1 eggs = f(e - 1, k - 1);
case 2: if egg dont break then we have to check (f - k) floor with e eggs = f(e , f - k);

*/
import java.util.*;
class eggDrop{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int e = scn.nextInt();  //eggs
		int f = scn.nextInt();  // floors
		int[][] dp = new int[e + 1][f + 1];

		//base cases
		// if egg == 0 min ways = 0
		// if floor  = 0 min ways = 0
		for(int i = 1; i <= e; i++){
			for(int j = 1; j <= f; j++){
				if(j == 1){ //floor == 1
					dp[i][j] = 1;
				}
				else if(i == 1){  //egg == 1
					dp[i][j] = j;
				}
				else{
					int min = Integer.MAX_VALUE;
					for(int mj = j - 1, pj = 0; mj >= 0; mj--, pj++){  //pj = previous j
						int v1 = dp[i][mj];  //egg survives
						int v2 = dp[i - 1][pj]; //egg breaks
						int val = Math.max(v1, v2);
						min = Math.min(min, val);

					}
					dp[i][j] = min + 1;
				}
			}
		}

		System.out.println(dp[e][f]);
	}
}