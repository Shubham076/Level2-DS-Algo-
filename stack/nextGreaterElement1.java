// leetcode 496
import java.util.*;
public class nextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        s.push(0);

        for(int i = 1; i < nums2.length; i++){
            while(s.size() > 0 && nums2[i] > nums2[s.peek()]){
                int idx = s.pop();
                map.put(nums2[idx], nums2[i]);
            }
            s.push(i);
        }

        while(s.size() > 0){
            int idx = s.pop();
            map.put(nums2[idx], -1);
        }

        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] ans = nextGreaterElement(nums1, nums2);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
