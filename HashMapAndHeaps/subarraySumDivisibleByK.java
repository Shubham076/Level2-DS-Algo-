/*
leetcode 971
print length of longest subArray divisible by k

1  2  3  4  5  6  7 
<---->
   s1
<--------------->
        s2
s1, s2 are sums;
s1 = kn + x;
s2 = km + x
s2 - s1 = k(m - n) which is divisible by k		   
*/
import java.util.*;
class subarraySumDivisibleByK {
	public static int subarraysDivByK(int[] a, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();  //remainder vs index
		map.put(0, -1);
		int sum = 0;
		int rem = 0;
		int ans = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
			rem = sum % k;
			if(rem < 0){
				rem += k;
			}
			if(map.containsKey(rem)){
				int idx = map.get(rem);
				int curLen = i - idx;
				if(curLen > ans){
					ans = curLen;
				}
			}
			else{
				map.put(rem, i);
			}
		}

		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 0, -2, -3, 1};
		int k = 5;
		System.out.println("Length of longest subarray: " + subarraysDivByK(arr, k));
	}
}