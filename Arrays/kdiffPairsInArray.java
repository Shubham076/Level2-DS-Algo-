//leetcode 532
import java.util.*;
public class kdiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int v: nums)
            m.put(v, m.getOrDefault(v, 0) + 1);

        int cnt = 0;
        for(int v: m.keySet()){
            if(k > 0 && m.containsKey(v + k) || k == 0 && m.get(v) > 1){
                cnt++;
            }
        }

        return cnt;
    }       
}
