//leetcode 875
import java.util.*;
public class kokoEatingbananas {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            //here mid is per hr banana eating capacity of koko
            int rhrs = getHrs(piles , mid);
            if(rhrs <= H){
                //finding more optimal ans
                high = mid - 1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static int getHrs(int[] arr , int cap){
        int h = 0;
        for(int i : arr){
            h += Math.ceil((double)i / cap);
        }
        return h;
    }
}
