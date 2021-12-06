/* leetcode 1248, 992
same logic as cnt of subarray with k diff integers
Given an array of integers nums and an integer k. A continuous subarray is called
 nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
O(N)
*/
import java.util.*;
class countNumberOfNiceSubarrays{
	public static int findAtmostk1(int[] nums, int k){
		int cnt = 0;
		int i = 0, co = 0;
		for(int j = 0 ; j < nums.length; j++){
			if(nums[j] % 2 == 1){
				co++;
			}
			while(co > k){
				if(nums[i] % 2 == 1){
					co--;
				}
				i++;
			}
			cnt += j - i + 1;
		}
        return cnt;
	}
	public static int findAtmostK2(int[] nums , int k) {
		int ans = 0;
		int i = -1;
		int j = -1;
		int cnt = 0;
		while (true) {
			while (i < nums.length - 1) {
				i++;
				if(nums[i] % 2 != 0){
					cnt++;
				}

				if (cnt <= k) {
					ans += (i - j);
				}
				else {
					break;
				}
			}

			if (i == nums.length - 1 && cnt <= k) {
				break;
			}

			while (j < i) {
				j++;
				if(nums[j] % 2 != 0){
					cnt--;
				}

				if (cnt <= k) {
					ans += (i - j);
					break;
				}
			}
		}
		return ans;
	}
	public int numberOfSubarrays(int[] nums, int k) {
     	int c1 =  findAtmostk1(nums, k);
     	int c2 =  findAtmostk1(nums, k - 1);
     	return c1 - c2;
    }
}