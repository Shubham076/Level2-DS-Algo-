//https://www.geeksforgeeks.org/maximum-sum-submatrix/

/*
for count in a number at i, j is present in how many submatrices 
(i, j)=> (i + 1) * (j + 1) * (n - i) * (m - j);
*/
import java.util.*;
class maximumSumSubmatrix {
	static void print(int[][] arr, int rs, int cs, int re, int ce) {
		for(int i = rs; i <= re; i++) {
			for(int j = cs; j <= ce; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");
	}
	// O(n ^ 6)
	static void find1(int[][] arr) {
		int ans = Integer.MIN_VALUE;
		int r = arr.length;
		int c = arr[0].length;
		int cnt = 0;
		//taking each row as starting row
		for(int i = 0; i < r; i++) {

			//taking each col as starting column
			for(int j = 0; j < c; j++) {

				//taking each row as ending row
				for(int k = i; k < r; k++) {

					//taking each col as ending col
					for(int l = j; l < c; l++) {	
						int lsum = 0;
						// print(arr, i , j , k , l);
						for(int x = i; x <= k; x++) {
							for(int y = j; y <= l; y++) {
								lsum += arr[x][y];
							}
						}
						ans = Math.max(ans, lsum);
					}
				}
			}
		}
		System.out.println(ans);
	}

	static int kadanes(ArrayList<Integer> arr){
		int omax = arr.get(0);
		int cmax = arr.get(0);
		for(int i = 1; i < arr.size(); i++) {
			if(cmax >= 0){
				cmax += arr.get(i);
			}
			else{
				cmax = arr.get(i);
			}
			omax = Math.max(omax, cmax);
		}
		return omax;
	}
	/*
	o(n * n * n) and O(n * n)
	Efficient Approach using Kadane’s Algorithm: 
	The above approach can be optimized using the following observations:

	Fix starting and ending column of the required sub-matrix say start and end respectively.
	Now, iterate each row and add row sum from starting to ending column to sumSubmatrix and insert
	this in an array. After iterating each row, perform Kadane’s Algorithm on this newly created array.
	If the sum obtained by applying Kadane’s algorithm is greater than the overall maximum sum, update
	the overall maximum sum.
	In the above step, the row sum from starting to ending column can be 
	calculated in constant time by creating an auxiliary matrix of size N*M
	containing the prefix sum of each row.
	*/ 
	static void find2(int[][] arr) {
		int[][] pre = new int[arr.length][arr.length];
		int max = Integer.MIN_VALUE;	
		//creating pefix sum matrix
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(j == 0) {
					pre[i][j] = arr[i][j];
				}
				else{
					pre[i][j] = arr[i][j] + pre[i][j - 1];
				}
			}
		}

		// for(int i = 0; i < pre.length; i++) {
		// 	for(int j = 0; j < pre[0].length; j++) {
		// 		System.out.print(pre[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println();

		//starting of each col
		for(int cs = 0; cs < arr[0].length; cs++) {
			
			//taking each col as ending col
			for(int ce = cs; ce < arr[0].length; ce++) {

				ArrayList<Integer> list = new ArrayList<>();
				//iterating over each row

				for(int i = 0; i < arr.length; i++) {
					int el = pre[i][ce] - (cs == 0 ? 0 : pre[i][cs - 1]);
					list.add(el);
				}
				int cmax = kadanes(list);
				max = Math.max(max, cmax);
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args){
		int[][] arr = {{0, -2, -7, 0},
					   {9,  3, -6, 2},
					   {-4, 11, 1, 1},
					   {-1, 8, 0, -2}};
		find1(arr);
		// find2(arr);
	}
}