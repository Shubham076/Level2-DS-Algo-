//leetcode 1005
import java.util.*;
// O(NLOGN) O(N) SPACE
class maxSumAfterKNegations {
	public static int largestSumAfterK_Negations(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		//add all the elements in the queue
		for (int n : nums) {
			pq.add(n);
		}

		//negative the smallest k element
		while (k-- > 0) {
			pq.add(pq.poll() * -1);
		}

		int sum = 0;
		for (int n : pq) {
			sum += n;
		}
		return sum;
	}

	/*
	1- sort the numbers in ascending order
	2- flip all the negative numbers, as long as k > 0 and we are not out of bounds(when k > nums.length) and we dont encounter 0 or positive number
	3- find the sum of the new array (with flipped numbers if any) and keep track of the minimum number
	 before returning the sum check the value of k after operations done in step 2 
	
	if(k is even) it will have no effect beacuse product of even negatives gives positive
	(we will flip a number and then get it back to the original)

	If it's odd, means the nummber have now become negative so
	remove twice of minimum its value from the result (why ? minimum because we have to maximize the sum)
	(twice because we already added it as positive in our sum operation)

	*/


	//without using the extra space O(NLOGN) O(1) SPACE
	public static int largestSumAfterK_Negations2(int[] nums, int k) {
			Arrays.sort(nums);
			int i = 0;
			while (k > 0 && i < nums.length && nums[i] < 0) {
				nums[i] = -nums[i];
				i++;
				k--;
			}

			int sum = 0;
			int min = Integer.MAX_VALUE;
			for (int n : nums) {
				sum += n;
				min = Math.min(min, n);
			}
			return sum - ((k % 2 )* min * 2);
	}
	public static void main(String[] args) {
		int[] arr = {1, 1};
		int k = 0;
		System.out.println(largestSumAfterK_Negations2(arr, k));
	}
}