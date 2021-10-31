//leetcode 923
import java.util.*;
class threeSumWithMultiplicity {
    static int mod = 1_000_000_007;

    public static int threeSumMulti(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            cnt = (cnt + map.getOrDefault(target - arr[i], 0)) % mod;

            for(int j = 0; j < i; j++){
                int sum = arr[i] + arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        int target = 8;
        System.out.println(threeSumMulti(arr, target));
    }
}