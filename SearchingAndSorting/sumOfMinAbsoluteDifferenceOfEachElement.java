import java.util.*;
class sumOfMinAbsoluteDifferenceOfEachElement{
	// O(n * n)
	static int bruteforce(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < arr.length; j++){
				if(j != i){
					min = Math.min(min, Math.abs(arr[i] - arr[j]));
				}
			}
			sum += min;
		}
		return sum;
	}

	// O(nlogn)
	static int optimized(int[] arr){
		Arrays.sort(arr);
		int sum = 0;
		int n = arr.length;
		sum += Math.abs(arr[0] - arr[1]); //first el
		sum += Math.abs(arr[n - 1] - arr[n - 2]); //last el
		for(int i = 1; i < n - 1; i++){
			sum += Math.min(Math.abs(arr[i] - arr[i - 1]), Math.abs(arr[i] - arr[i + 1]));
		}
		return sum;
	}
	public static void main(String[] args){
		int[] arr = {5, 10, 1, 4, 8, 7};
		System.out.println(bruteforce(arr));
		System.out.println(optimized(arr));
	}
}