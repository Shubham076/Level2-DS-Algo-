import java.util.*;
public class firstmissingPositive {
    //time O(N) space O(N)
    public static int FirstMissingPositive1(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i : nums){
            s.add(i);
        }

        int i = 1;
        while(s.contains(i)){
            i++;
        }

        return i;
        
    }
    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //time complexity O(n) space O(1);
    public static int FirstMissingPositive2(int[] nums){
        int checkRange = nums.length; // 1 --- n
        for(int i = 0; i < nums.length; i++){
            if((i + 1) == nums[i]) continue;
            if(nums[i] < 1 || nums[i] > checkRange) continue; // checking if out of range or not

            int si = i;
            int ei = nums[i] - 1;
            if(nums[ei] == nums[si]) continue; //for escaping infinite loop
            swap(si, ei, nums); 
            i--;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != (i + 1)) return i + 1;
        }
        return checkRange + 1;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 0};
        System.out.println(FirstMissingPositive2(arr));                       
    }
}
