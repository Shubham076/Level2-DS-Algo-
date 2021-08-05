//leetcode 1248
//same logic as cnt of subarray with k diff integers
import java.util.*;
class countNumberOfNiceSubarrays{
	public static int findAtmostK(int[] nums , int k) {
		int ans = 0
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
     	int c1 =  findAtmostK(nums, k);
     	int c2 =  findAtmostK(nums, k - 1);
     	return c1 - c2;
    }
}