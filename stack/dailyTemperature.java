//leetcode 739 next greater element on the right
import java.util.*;
class dailyTemperature{
	public int[] dailyTemperatures(int[] arr) {
     	Stack<Integer> st = new Stack<>();
     	int n = arr.length;
     	int[] ans = new int[n];
     	st.add(0);
     	for(int i = 0; i < n; i++){
     		while(st.size() > 0 && arr[i] > arr[st.peek()]){
     			int idx = st.peek();
     			ans[idx] = i - idx;
     			st.pop();
     		}
     		st.push(i);
     	}
     	while(st.size() > 0){
     		int idx = st.peek();
     		st.pop();
     		ans[idx] = 0;
     	}    
     	return ans;
    }
}