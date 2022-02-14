/* leetcode 454
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 return the number of tuples (i, j, k, l) such that:
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
o(n * n)
*/
import java.util.*;
class fourSum{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int v: nums3){
            for(int n: nums4){
                map.put(v + n, map.getOrDefault(v + n, 0) + 1);
            }
        }
        int cnt = 0;
        for(int v: nums1){
            for(int n: nums2){
                cnt += map.getOrDefault(-(v + n), 0);
            }
        }
        return cnt;
    }
}