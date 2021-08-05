//print count of the subArrays sum equal to  k 
//leetcode 560
import java.util.*;
class subArraySumEqualToK{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int ans = 0;

		for(int i : arr){
			sum += i;
			int rsum = sum - target;
			if(map.containsKey(rsum)){
				ans += map.get(rsum);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		System.out.println(ans);
	}
}