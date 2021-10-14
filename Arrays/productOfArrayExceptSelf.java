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

    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] ans = productExceptSelf(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
