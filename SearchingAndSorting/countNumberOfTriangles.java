/*
https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1
traingle property sum of 2 sides is greater than the third side
O(n * n);
*/
import java.util.*;
class countNumberOfTriangles {
	static int findNumberOfTriangles(int arr[], int n) {
		Arrays.sort(arr);
		int cnt = 0;
		for (int i = n - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;
			while (l < r) {
				int sum = arr[l] + arr[r];
				if (sum > arr[i]) {
					cnt += r - l;
					r--;
				} else {
					l++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[] arr = {6, 4, 9, 7, 8};
		System.out.println(findNumberOfTriangles(arr, arr.length));
	}
}