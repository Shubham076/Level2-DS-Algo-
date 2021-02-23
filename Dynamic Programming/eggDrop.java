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