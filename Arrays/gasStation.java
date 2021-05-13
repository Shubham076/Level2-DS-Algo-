//leetcode 134 
import java.util.*;
//answer is always index next to minimum of the prefix;
class gasStation{
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int idx = 0;
        int n = gas.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum += gas[i] - cost[i];
            if(sum < min){
                min = sum;
                idx = i + 1;
            }
        }
        
        return sum >= 0 ? (idx) % n : -1;
    }
}