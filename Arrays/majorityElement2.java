import java.util.*;
//in this we make triplets
class majorityElement2{
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int val1 = nums[0] , val2 = nums[0];
        int cnt1 = 1, cnt2 = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == val1){
                cnt1++;
            }
            else if(nums[i] == val2){
                cnt2++;
            }
            else if(cnt1 == 0){
                val1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                val2 = nums[i];
                cnt2 = 1;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;

        for(int i : nums){
            if(i == val1){
                cnt1++;
            }
            if(i == val2){
                cnt2++;
            }
        }   
        int n = nums.length;
        if(cnt1 > n/3) ans.add(val1);
        if( val1 != val2 && cnt2 > n/3) ans.add(val2);
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement(arr));
    }
}