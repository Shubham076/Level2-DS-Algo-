/*
Q => maximum sum we can achieve of arr[i] * i;
only operation is allowed is you can rotate the array

//bruteforce genrate all the rotations and calculate sum O(N * N);


O(N) intuition
arr = [a, b, c, d, e];
     0  1  2  3  4
after rotating the array by one array becomes
arr' = [e, a, b, c, d]
 	   0  1  2  3  4

s0 = a * 0 + b * 1 + c * 2 + d * 3 + e * 4;

after rotation
s1 = a * 1 + b * 2 + c * 3 + d * 4 + e * 0

there is a relation between s0 and s1
s1 = s0 + (a + b + c + d + e) - n * e;

so the general formula becomes 
s(i + 1) = s(i) + (a + b + c + d + e - n) * arr[n - 1 - i];
*/
import java.util.*;
class maxSumInConfiguration{
	static int max_sum(int[] a, int n){
	// Your code here
		int sum = 0, s0 = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
			s0 += a[i] * i;
		}

		int si = s0;
		int max = s0;
		for(int i = 0; i < n - 1; i++){
			int sip1 = si + sum - n * a[n - 1 - i];  //sip1 => s(i + 1)
			max = Math.max(max, sip1);
			si = sip1; 
		}
		return max;
    }
	public static void main(String[] args){
		int[] arr = {8, 3, 1, 2};
		System.out.println(max_sum(arr, arr.length));
	}
}