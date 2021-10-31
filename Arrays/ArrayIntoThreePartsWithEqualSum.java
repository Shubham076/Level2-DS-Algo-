//leetcode 1013
import java.util.*;
public class ArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum  = Arrays.stream(arr).sum();
        if(sum % 3 != 0) return false;
        int cnt = 0, psum = 0;
        for(int i = 0; i < arr.length; i++){
            psum += arr[i];
            if(psum == sum / 3){
                cnt++;
                psum = 0;
            }
        }
        return cnt >= 3;
    }
}
