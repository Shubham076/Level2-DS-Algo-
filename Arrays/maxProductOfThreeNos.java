//leetcode 628
public class maxProductOfThreeNos {
    public static int maximumProduct(int[] nums) {
        int ans = 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        for(int i : nums){
            if(i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }
            else if(i > max2){
                max3 = max2;
                max2 = i;
            }
            else if(i > max3){
                max3 = i;
            }

            if(i < min1){
                min2 = min1;
                min1 =i;
            }
            else if(i < min2){
                min2 = i;
            }
        }

        p1 = max1 * max2 * max3;
        p2 = min1 * min2 * max1;
        ans = Math.max(p1, p2);
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {-1,-2,-3};
        System.out.println(maximumProduct(nums));
    }
}
