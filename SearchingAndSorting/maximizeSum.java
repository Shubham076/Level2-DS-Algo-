//maximize the sum of arr[i] * i;
//bruteforce solution to generate all the permutations and check the sum for each O(n! * n);
import java.util.*;
class maximizeSum {
	//O(NlogN)
	static int maximize(int arr[]) {
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i] * i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] arr = {2, 9, 4, -1, 6};
		System.out.println(maximize(arr));
	}
}