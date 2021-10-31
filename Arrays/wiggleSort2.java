//leetcode 324 
// nums[0] < nums[1] > nums[2] < nums[3]....
import java.util.*;
class wiggleSort2{
    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.sort(nums);
        int i = 1;
        int j = n - 1;
        while(i < n){
            ans[i] = nums[j];
            j--;
            i += 2;
        }
        i = 0;
        while(i < n){
            ans[i] = nums[j];
            j--;
            i += 2;
        }
        for(i = 0; i < n; i++){
            nums[i] = ans[i];
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 5, 1, 1, 6, 4};
        wiggleSort(arr);
        for(int v: arr){
            System.out.print(v + " ");
        }
    }
}
