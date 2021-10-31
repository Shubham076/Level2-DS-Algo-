import java.util.*;
class subarraySumEqualto0{
	public static void main(String[] args){
		HashMap<Integer, Integer> map = new HashMap<>(); //sum vs 
		int sum = 0;
		int count = 0;
		map.put(0, 1);
		int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		int n = arr.length;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			if(map.containsKey(sum)) count += map.get(sum);
			map.put(sum , map.getOrDefault(sum, 0) + 1); 
		}
		System.out.println(count);
	}

	public static void printSubArray(int start , int end , int[] arr){
		for(int i = start; i <= end; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}