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

/*
proof: 
let delta = gas[i] - cost[i]
condition when it is impossible to do a circular tour : 
    * if the total sum of delta comes out to be negative 
    * why ? if the total delta comes out to be negative means total gas in less than total cost;

conition that one can travel to next station
 1: gas[i] - cost[i] >= 0
 2: buffer + gas[i] - cost[i] >= 0
 if either of two conditions are true means we can travel to next station
 (here buffer is that fuel left in the tank after travelling from previous station 
 buffer can be negative, positive or 0;) example below:

        station  0 1 2
            cost 2 3 2
            gas  5 0 2
    now when the driver reaches the station 1 if has a buffer of 3. To reach station 2 it need a fuel of 3 units.
    Even though the driver can't refill his tank here but still reach the station 3 coz he need 3 units of petrol to reach and
    3 units is left in the buffer. (We can also verify with condition 2 = 0 - 3 + 3 = 0)  

//now we know the answer is the index next to min delta
let us assume that index of min delta prefix is i;
    
    delta_prefix[i] <= delta_prefix[i + 1]; 
    delta_prefix[i] <= delta_prefix[i] + gas[i + 1] - cost[i + 1]
    gas[i + 1] - cost[i + 1] >= 0  ( * proofs the condition one);

=> means we can travel from (i + 1)th station to (i + 2);

similary we can say that
    delta_prefix[i] <= delta_prefix[i + 2]; 
    delta_prefix[i] <= delta_prefix[i + 1] +  gas[i + 2] - cost[i + 2]
    delta_prefix[i] <= delta_prefix[i] + gas[i + 1] + cost[i + 1] +  gas[i + 2] - cost[i + 2]
    gas[i + 1] + cost[i + 1] + gas[i + 2] - cost[i + 2] >= 0
    buffer  + gas[i + 2] + cost[i + 2] >= 0 [gas[i + 1] + cost[i + 1] = buffer]
    * proofs the second eq.

=> means we can travel from (i + 2) station to (i + 3); 
from above two proofs we can say from (i + 1) -> (i + 2) -> (i + 3) --- (i + N - 1)so on;

//second proof for the 0th index
    (for solution to be exist below equaltion holds true)
    gas[0] + cost[0] + gas[1] - cos[1] + ------ gas[i] - cost[i] + gas[i  + 1] - cost[i + 1] -------- gas[i + N - 1] - cost[i + N - 1] >= 0  i
    
* gas[0] + cost[0] + gas[1] - cos[1] + ------ gas[i] - cost[i] is nothing but delta_prefix[i];
and we also know that delta_prefix[i] <= delta_prefix[0]; --------ii

from eq i && ii we can say that 
delta_prefix[0] +  gas[i  + 1] - cost[i + 1] -------- gas[i + N - 1] - cost[i + N - 1] >= 0
gas[0] + cost[0] +  gas[i  + 1] - cost[i + 1] -------- gas[i + N - 1] - cost[i + N - 1] >= 0
buffer + gas[0] + cost[0] >= 0; hence proved condition two;

similarly we can prove this for 1 , 2, upto (i) th index;
*/