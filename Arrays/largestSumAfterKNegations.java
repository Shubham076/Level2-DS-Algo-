/*
binarySearch 708
Intuition
In order to maximize the sum our first priority is to convert the negatives to positives

Implementation
1- sort the numbers in ascending order
2- flip all the negative numbers, as long as k > 0 and we are not out of bounds(when k >= nums.length) and we dont encounter 0 or positive number
3- find the sum of the new array (with flipped numbers if any) and keep track of the minimum number
4-before returning the sum check the value of k after operations done in step 2

If(k is even) it will have no effect beacuse product of even negatives gives positive
(we will flip a number and then get it back to the original)

If it's odd, means the nummber have now become negative so
remove twice of minimum its value from the result (why ? minimum because we have to maximize the sum)
(twice because we already added it as positive in our sum operation)
*/
import java.util.*;
class largestSumAfterKNegations{
	public int solve2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
         PriorityQueue<Integer> pq = new PriorityQueue<>();

        //add all the elements in the queue
        for(int n : nums){
        	pq.add(n);
        }

        //negative the smallest k element
        while(k-- > 0){
        	pq.add(pq.poll() * -1);
        }

        int sum = 0;
        for(int n : pq){
        	sum += n;
        }
        return sum;
    }
	 public static int solve(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
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
        return sum - (k % 2) * min * 2;
    }
	public static void main(String[] args) {
		int[] arr = {1, 0, -3, -5};
		int k = 4;
		System.out.println(solve(arr, k));
	}
}