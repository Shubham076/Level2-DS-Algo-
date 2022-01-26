/*
leetcode 446
return the cnt of aps subsequences having cnt >= 3
storage arr[hashamp<integer, integer]
hashmap denoting common diff and cnt of ap of length >=2 ending at ith index
*/
import java.util.*;
class arithmeticSlices2{
	public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Long>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++){
        	dp[i] = new HashMap<>();
        }
        int cnt = 0;
        for(int i = 1; i < n; i++){
        	for(int j = 0; j < i; j++){
        		long cd = (long)nums[j] - (long)nums[i];
        		if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) continue;
        		long endingAtJ = dp[j].getOrDefault(cd, 0L); // getting the cnt of aps ending at j having common diff = cd
        		long endingAtI = dp[i].getOrDefault(cd, 0L); // getting the cnt of aps ending at i having common diff = cd
        		cnt += endingAtJ;
        		dp[i].put(cd, 1 + endingAtJ + endingAtI);
        	}
        }
        return cnt;
    }
	public static void main(String[] args){
		int[] arr = {7, 7, 7, 7};
		System.out.println(numberOfArithmeticSlices(arr));
	}
}


