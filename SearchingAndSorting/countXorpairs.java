/*
Given an array A[ ] of size N. Find the number of pairs (i, j) such that
A[i] XOR A[j] = 0, and 1 <= i < j <= N.
*/
import java.util.*;
class countXorpairs {
	public static int count(int[] arr){
		int n = arr.length;
		int[] freq = new int[10];  //max of arr
		for(int i = 0; i < n; i++){
			freq[arr[i]]++;
		}
		//xor have a property xor of same numbers is always 0
		// so we cnt freq and we can make (n * n -1 / 2) pairs with n elements;
		int cnt = 0;
		for(int i = 0; i < freq.length; i++){
			int v = freq[i];
			cnt += v * (v - 1) / 2;
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[] arr = {2, 2,2};
		System.out.println(count(arr));
	}
}