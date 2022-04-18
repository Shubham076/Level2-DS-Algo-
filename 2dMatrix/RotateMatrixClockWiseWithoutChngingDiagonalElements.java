/*
https://www.geeksforgeeks.org/rotate-all-matrix-elements-except-the-diagonal-k-times-by-90-degrees-in-clockwise-direction/
1 2 3  
4 5 6  
7 8 9  

output: 
1 4 3
8 5 2
7 6 9

transpose       reverse        reverse primary           replace secd diagonal with reverse of indices 
                row            diag with secd diagonal   (i, j) to (j, i) for r / 2
 1 4 7            7 4 1       1 4 7                       1 4 3
 2 5 8     =      8 5 2   =   8 5 2                   =   8 5 2
 3 6 9            9 6 3       3 6 9                       7 6 9
*/

import java.util.*;
class RotateMatrixClockWiseWithoutChngingDiagonalElements {
	static void rotate(int[][] arr) {
		int n = arr.length, m = arr[0].length;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < m; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp; 
			}
		}

		//reverse rows
		for(int i = 0; i < n; i++) {
			int left = 0, right = m - 1;
			while(left < right) {
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				left++;
				right--;
			}
		}

		//now we have to reverse the steps for diagonal elements
		for(int i = 0; i < n; i++){
			int temp = arr[i][i];
			arr[i][i] = arr[i][n - i - 1];
			arr[i][n - i - 1] = temp;
		}

		for(int i = 0; i < n / 2; i++) {
			int temp = arr[i][n - i - 1];
			arr[i][n - i - 1] = arr[n - i - 1][i];
			arr[n - i - 1][i] = temp;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, 
	                   {4, 5, 6},
	                   {7, 8, 9}};
	    rotate(arr);
	}
}

