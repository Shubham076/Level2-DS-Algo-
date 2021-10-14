import java.util.*;
//for circular arrays run the loop 2 times
// time complexity O(N)
public class nextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans , -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < nums.length * 2; i++){
            while(s.size() > 0 && nums[i % nums.length] > nums[s.peek()]){
                int idx = s.pop();
                ans[idx] =  nums[i % nums.length];
            }
            s.push(i % nums.length);
        }        
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 1};
        int[] ans = nextGreaterElements(arr);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
