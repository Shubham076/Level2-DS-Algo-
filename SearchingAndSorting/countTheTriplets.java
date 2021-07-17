/*
https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
count all the triplets in which sum of all 2 elements is equal to third element 
bruteforece o(N ^ 3)

efficient O(N * N);
*/

// 1 2 3 5
import java.util.*;
class countTheTriplets{
	static int countTriplet(int arr[], int n) {
		Arrays.sort(arr);
		int cnt = 0;
		for(int i = n - 1; i >= 2; i--){
			int l = 0;
			int r = i - 1;
			while(l < r){
				int sum = arr[l] + arr[r];
				// System.out.print(sum + " " + arr[i] + ",");
				if(sum == arr[i]){
					l++;
					r--;
					cnt++;
				}
				else if(sum < arr[i]){
					l++;
				}
				else{
					r--;
				}
			}
		}
		return cnt;
    }
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 2};
		System.out.println(countTriplet(arr, arr.length));
	}
}