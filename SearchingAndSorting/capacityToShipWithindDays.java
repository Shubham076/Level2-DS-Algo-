//leetcode 1011
import java.util.*;
public class capacityToShipWithindDays {
    public int shipWithinDays(int[] weights, int D) {
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();

        int low = max;
        int high = sum;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rDays = requiredDays(weights, mid); // required days

            if (rDays <= D) {
                high = mid - 1;
                ans = mid;
            } 
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int requiredDays(int[] arr, int capacity) {
        int csum = 0;
        int day = 1;
        for (int v : arr) {
            if (csum + v > capacity) {
                day++;
                csum = 0;
            }
            csum += v;
        }
        return day;
    }
}
