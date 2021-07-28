/*
	given an array find the length if longest even odd subarray
	we know that sum  of two even and sum of two odd numbers is always even
	ans sum of odd and even is always even
	we will use the same property here 
*/
class lengthofLongestEvenOddSubarray{
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 5, 7, 9, 10};
		int cnt = 1;
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++){
			if((arr[i] + arr[i - 1]) % 2 != 0){
				cnt++;
			}
			else{
				ans = Math.max(ans, cnt);
				cnt = 1;
			}
		}
		ans = Math.max(ans, cnt);
		System.out.println(ans);
	}
}