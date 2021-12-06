/* leetcode 581
Given an integer array nums, you need to find one continuous subarray that if you
only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
Return the shortest such subarray and output its length.

*/
import java.util.*;
class shortestUnsortedSubarray{
    //O(n * n * n)
    /*
    Algorithm:
    1: we consider every possible subarray that can be formed from the given array numsnums. For every subarray nums[i:j]nums[i:j] considered, we need to check whether this is the smallest unsorted subarray or not. Thus, for every such subarray considered, we find out the maximum and minimum values lying in that subarray given by maxmax and minmin respectively.

    2: we also need to check if nums[0:i-1]nums[0:i−1] and nums[j:n-1]nums[j:n−1] are sorted correctly. If all the above conditions are satisfied, we determine the length of the unsorted subarray as j-ij−i. We do the same process for every subarray chosen and determine the length of the smallest unsorted subarray found.
    */
    public static int findUnsortedSubarray1(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++){
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
                
                if(i > 0 && nums[i - 1] > min || j + 1 < nums.length && nums[j + 1] < max){
                    continue;
                }
                //checking if left part is sorted
                int k = 0;
                while(k < i && prev <= nums[k]){
                    prev = nums[k++];
                }
                if(k != i) continue;

                //checkong right part is sorted or not
                k = j + 1;
                while(k < nums.length && prev <= nums[k]){
                    prev = nums[k++];
                }

                if(k == nums.length){
                    int len = j == i ? 0 : j - i + 1;
                    ans = Math.min(ans, len);
                }
            }
        }
        return ans;
    }

    /*
    O(n * n)
    Algorithm: similar to selection sort 
    */
    public static int findUnsortedSubarray2(int[] nums){
        int l = nums.length;
        int r = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    l = Math.min(l, i);
                    r = Math.max(r, j);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    //same approcah as above just compare the sorted and unsorted array O(nlogn)
    public static int findUnsortedSubarray3(int[] nums){
        int l = nums.length;
        int r = 0;
        int[] narr = nums.clone();
        Arrays.sort(narr);
        for(int i = 0; i < nums.length; i++){
            if(narr[i] != nums[i]){
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    //O(n)
    public static int findUnsortedSubarray4(int[] nums){
        int start = -1, end = -1, max = nums[0], min = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){

            //snmaller than max of left
            if(nums[i] < max){
                end = i;
            }
            max = Math.max(max, nums[i]);
        }

        for(int i = nums.length - 2; i >= 0; i--){
            //greater than smaller of right
            if(nums[i] > min){
                start = i;
            }

            min = Math.min(min, nums[i]);
        }
        return start == end ? 0 : end - start + 1;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};
        int ans1 = findUnsortedSubarray3(arr);
        System.out.println(ans1);
    }
}