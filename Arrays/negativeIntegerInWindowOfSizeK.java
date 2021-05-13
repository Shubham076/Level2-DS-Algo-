// First negative integer in every window of size k
class negativeIntegerInWindowOfSizeK {
	public static long[] printFirstNegativeInteger(long arr[], int N, int k) {
		long[] ans = new long[N - k + 1];
		int nearestNegative = -1;
		for(int i = N - 1; i >= N - k; i--){
			if(arr[i] < 0){
				nearestNegative = i;
			}
		}
		ans[ans.length - 1] = nearestNegative == -1 ? 0 : arr[nearestNegative];;
		for(int i = N - k - 1; i >= 0; i--){
			if(arr[i] < 0){
				ans[i] = arr[i];
				nearestNegative = i;
			}
			else if(nearestNegative <= i + k - 1 && nearestNegative != -1){
				ans[i] = arr[nearestNegative];
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		long[] arr = { -8, 2, 3, -6, 10};
		int k = 2;
		long[] ans = printFirstNegativeInteger(arr, arr.length, k);
		for (long a : ans) {
			System.out.print(a + " ");
		}
	}
}