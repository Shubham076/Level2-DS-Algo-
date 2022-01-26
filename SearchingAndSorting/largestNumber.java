//leetcode 179
import java.util.*;
class largestNumber{
	public static String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			a[i] = nums[i] + "";
		}
        Arrays.sort(a, (p, q) -> {
        	long n1 = Long.parseLong(p + q);  //102
        	long n2 = Long.parseLong(q + p);  //210
        	if(n1 > n2){
        		return 1;
        	}
        	else{
        		return -1;
        	}
        });
        String ans = "";
        for(int i = nums.length - 1; i >= 0; i--){
        	ans += a[i];
        }
        if(ans.charAt(0) == '0'){
        	return "0";
        }
        else
        	return ans;
    }

	public static void main(String[] args){
		System.out.println(largestNumber(new int[]{10, 2}));
	}
}