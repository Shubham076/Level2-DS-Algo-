/*
leetcode 665
we simply have to check all possible cases
1: if cnt > 1 where arr[i] < arr[i - 1] we simply return false as in question only element is allowed to flip 
2: if cnt == 1
	then we have 4 conditions: 
case 1  first we check pos of dip is at 1 idx we return true and we can change value to any possible one
		other wise move to next 
           *
      *
*   
____*____________
2  1  3   4

case 2 then we check if dip is at n - 1 idx we return true (as we can easily change the value of end to make it increasing)
otherwise check for next condition
        *
            *
   *       
*
_______________
1  2  5   3

case 3 we check if arr[i - 1] <= arr[i + 1] we return true(as we can easily make the ith idx in range of arr[i - 1] && arr[i + 1])
otherwise move to next condition.
           *
    *  
       *
*
--------------        in this case we can change 2 to any value in range( 3- 4)
1  3  2  4 

case 4 we check if arr[i - 2] <= arr[i] we return true(as we can easily make the i - 1th idx in range of arr[i - 2] && arr[i])
                  
   *
          *
      * 
*      
----------------  
1  6  2  5

otherwise return false
*/

import java.util.*;
class nonDecreasingArray {
	public static boolean checkPossibility(int[] arr) {
		int pos = -1;
		int n = arr.length;
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i - 1]){
				if(pos != -1){
					return false;
				}
				pos = i;
			}
		}

		//pos == -1 indicates arrays is already in increasing order
		return pos == -1 || pos == 1 || pos == n - 1 || arr[pos - 1] <= arr[pos + 1] || arr[pos - 2] <= arr[pos];
	}
	public static void main(String[] args) {
		int[] arr = {4, 2, 1};
		System.out.println(checkPossibility(arr));
	}
}