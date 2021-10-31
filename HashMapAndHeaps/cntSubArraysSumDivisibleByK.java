/*
<------------------> s1
we can express s1 as => kn + x

<------> s2
s2 = km + x;
s2 - s1 = k(m - n)
*/


import java.util.*;
class cntSubArraysSumDivisibleByK{
	public static int subarraysDivByK(int[] a, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();  //remainder vs cnt
		map.put(0, 1);
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
				ans += map.get(rem);
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 0, -2, -3, 1};
		int k = 5;
		System.out.println(subarraysDivByK(arr, k));
	}
}