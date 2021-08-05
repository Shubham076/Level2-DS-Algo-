/* 
https://www.geeksforgeeks.org/check-whether-arithmetic-progression-can-formed-given-array/
first two terms of ap are smallest and second smallest always
then find the common diff and verify the entire array 
*/
import java.util.*;
class checkApSequence{
	static boolean checkIsAP(int arr[] ,int n){
		HashSet<Integer> set = new HashSet<>();
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		boolean flag = true;
		for(int i : arr){
			if(i < min1){
				min2 = min1;
				min1 = i;
			}
			else if(i < min2){
				min2 = i;
			}
			if(!set.add(i)){
				flag = false;  //means duplicates
			}
		}

		//edge case = [2,2,2,2]  commonn diff = 0
		if(flag == false && set.size() == 1){
			return true;
		}

		//edge case [2, 2, 3, 4]  repetion cases
		if(flag == false && set.size() != 1){
			return false;
		}

		int d = min2 - min1;
		set.remove(min1);
		set.remove(min2);
		int x = min2;
		while(true){
			if(set.contains(x + d)){
				set.remove(x + d);
				x = x + d;
			}
			else{
				break;
			}
		}
		return set.size() == 0;
    }

    public static void main(String[] args) {
    	int[] arr = {0, 12, 4, 9};
    	System.out.println(checkIsAP(arr, arr.length));
    }
}