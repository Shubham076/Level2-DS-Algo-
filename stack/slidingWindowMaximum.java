/*
//leetcode 239
using deque
O(n) o(k) space
*/
import java.util.*;
class slidingWindowMaximum{
	public static void main(String[] args){
		int[] arr = {4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5};
		int k = 3;
		ArrayDeque<Integer> dq = new ArrayDeque<>();  //storing the index
		int[] ans = new int[arr.length - k + 1];
		int idx = 0;
		for(int i = 0; i < arr.length; i++){

			//removing the el of previous window as we are sliding
			if(dq.size() != 0 && dq.peekFirst() == i - k){
				dq.removeFirst();
			}

			//for maintaing the decreasing order removing all the el which less than current
			while(dq.size() > 0 && arr[dq.peekLast()] <= arr[i]){
				dq.removeLast();
			}

			dq.addLast(i);
			if(i >= k - 1)
				ans[idx++] = arr[dq.peekFirst()];
		}

		for(int v: ans){
			System.out.print(v + " ");
		}
	}
}