//leetcode 895
import java.util.*;
class MaxFrequencyStack {
	HashMap<Integer, Integer> freq;   //integer ve frequency
	HashMap<Integer, Stack<Integer>> freqStack; //freq vs stack of integers
	int max;

	MaxFrequencyStack(){
		freq = new HashMap<>();
		freqStack = new HashMap<>();
		max = 0;
	}

	public void push(int val){
		int f = freq.getOrDefault(val, 0) + 1;
		freq.put(val, f);

		//updating the max freq;
		max = Math.max(max, f);

		//ading the values in the stack
		freqStack.putIfAbsent(f, new Stack<>());
		freqStack.get(f).push(val);
	}
	public int pop(){
		Stack<Integer> s = freqStack.get(max);
		int val = s.pop();
		if(s.size() == 0){
			max--;
		}
		freq.put(val, freq.get(val) - 1);
		return val;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 4, 5};
		MaxFrequencyStack s = new MaxFrequencyStack();
		for(int i : arr){
			s.push(i);
		}
		int x = s.pop();
		System.out.println(x);
	}
}