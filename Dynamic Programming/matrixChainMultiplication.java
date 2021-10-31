
/*
	return the min number of multiplications needed
*/
import java.util.*;
class matrixChainMultiplication{
	public static void main(String[] args){
		long start = System.nanoTime();
		int[] arr = {10, 20, 30, 40, 50};
		int[][] dp = new int[arr.length - 1][arr.length - 1];
		for(int g = 0; g < dp.length; g++){
			for(int i = 0, j = g; j < dp.length; j++, i++){
				if(g == 0){
					dp[i][j] = 0;
				}
				else if(g == 1){
					dp[i][j] = arr[i] * arr[j] * arr[j + 1];
				}
				else{
					int min = Integer.MAX_VALUE;
					for(int k = i; k < j; k++){
						int lc = dp[i][k];
						int rc = dp[k + 1][j];
						int m = arr[i] * arr[k + 1] * arr[j + 1];
						int total = lc + rc + m;
						if(total < min){
							min = total;
						}
						dp[i][j] = min;
					}
				}
			}
		}

		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp.length; j++){
				System.out.format(" % 7d ",dp[i][j]);
			}
			System.out.println();
		}
		System.out.println(dp[0][dp.length - 1]);
		long end = System.nanoTime();
		System.out.println("Execution Time: " + (end - start) / 1000000 + "ms");	
	}
}