import java.util.*;
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