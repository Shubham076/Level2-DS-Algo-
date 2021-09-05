/*
Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack. Determine the minimum number of steps required to make all of the piles equal in height.
Input: piles = [5, 2, 1]
Output: 3
Explanation:
Step 1: reducing 5 -> 2 [2, 2, 1]
Step 2: reducing 2 -> 1 [2, 1, 1]
Step 3: reducing 2 -> 1 [1, 1, 1]
So final number of steps required is 3.
*/
import java.util.*;
public class minStepsToMakePilesEqualHeight {
    public static void main(String[] args){
        Integer[] arr = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
        Arrays.sort(arr, Collections.reverseOrder());
        int cnt = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]){
                cnt += i;
            }
        }
        System.out.println(cnt);
    }
}
