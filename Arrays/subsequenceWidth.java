import java.util.*;

/*
we have to find the sum of all (diff of max and min of subsequence)
we know that an array of length n have 2 ^ n subsequences
if we sort the array we can find two things
for eg array = 1,2,4
2 will act as max for all subsequences ending at 2
2 will act as min for all subsequences starting at 2
 and we have to find the subseqiences witdth for all numbers
*/
class subsequenceWidth{
	static int a = (int)1e9 + 7;
	public static int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        long[] pow = new long[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++){
        	pow[i] = pow[i - 1] * 2 % a;
        }
        for(int i = 0; i < nums.length; i++){
        	ans = (ans + (pow[i] - pow[n - i - 1]) * nums[i]) % a;
        }

        return (int)ans;
    }
	public static void main(String[] args) {
		int[] arr = {2, 1, 3};
		System.out.println(sumSubseqWidths(arr));
	}
}