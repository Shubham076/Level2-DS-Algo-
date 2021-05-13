//leetcode 238
public class productOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int prod = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * prod;
            prod *= nums[i];
        }

        return res;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int prod = 1;
        int zeroCount = 0;
        for (int i : nums) {
            if(i == 0){
                zeroCount++;
                continue;
            }
            else{
                prod *= i;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(zeroCount == 0) res[i] = prod / nums[i];
            
            else if(zeroCount == 1){
                if(nums[i] == 0) res[i] = prod;
                else res[i] = 0;
            }
            else{
                res[i] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] ans = productExceptSelf2(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
