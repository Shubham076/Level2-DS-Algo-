// find the max of sum of smallest and second smallest in all the subarrays
/*
let us consider all the subarrays of sze >= 2
                       min                smin              sum
4 3          =>       3                     4                12
4 3 1                 1                     3                 4 
4 3 1 5               1                     3                 4
4 3 1 5 6             1                     3                 4

3 1                   1                     3                  4
3 1 5                 1                     3                  4
3 1 5 6               1                     3                 4

1 5                   1                     5                  6
1 5 6                 1                     5                  6

5 6                   5                      6                  11 

after considering all the eg we can see that maxim sum of array is always given when first 2 elements of
subarray are considered

so we just need to compete the sum of 2 consecutive numbers
*/
class maxSumOfSmallestandSecondSmallest{
	public static void main(String[] args) {
		int[] arr = {4, 3, 1, 5, 6};
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length - 1; i++){
			max = Math.max(max , (arr[i] + arr[i + 1]));
		}
		System.out.println(max);
	}
}