/*
https://practice.geeksforgeeks.org/problems/morning-assembly3038/1 Given an
array arr[] of N elements containing first N positive integers. You have to
sort the integers in ascending order by the following operation. Operation is
to pick an integer and place it at end or at start. Every such operation
increases cost by one. The task is to sort the array in the minimum cost

just find the longest consecutive sequence
the elements which are already in their correct position we dont need to move
remaining elements we need to move
so we find the longest consecutive sequence and answer is going to be n - len(sequence);
*/
import java.util.*;
class trickyArraySorting{
	//
	static int sortingCost(int N, int arr[]){
        //longest consecutive subsequence
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
        	int n = arr[i];
        	if(map.containsKey(n - 1)){
        		int v = map.get(n - 1);
        		map.put(arr[i], v + 1);
        		max = Math.max(max, v + 1);
        	}
        	else{
        		map.put(arr[i], 1);
        	}
        }
       return N - max;
    }
	public static void main(String[] args) {
		int[] arr = {4, 3, 1, 2};
		System.out.println(sortingCost(arr.length, arr)); 
	}
}