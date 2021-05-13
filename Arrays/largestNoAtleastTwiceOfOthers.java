//leetcode 747
public class largestNoAtleastTwiceOfOthers {
    public static int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
                idx = i;
            }
            else if(nums[i] > max2){
                max2 = nums[i];
            }
        }

        if(max1 >= (2 * max2)){
            return idx;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};
        System.out.println(dominantIndex(nums));
    }
}
