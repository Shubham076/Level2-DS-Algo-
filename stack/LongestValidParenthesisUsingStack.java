import java.util.*;
class LongestValidParenthesisUsingStack {
	public static void main(String[] args){
		String str = ")(";
		Stack<Integer> s = new Stack<>();  //storing the indexes of base string 
		s.push(-1);
		int ans = 0;

		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c == '(') s.push(i);
			else{

				if(!s.isEmpty()){
					s.pop();
				}

				// Check if this length formed with base of
                // current valid substring is more than max so far
				if(!s.isEmpty()){
					int len = i - s.peek();
					if(len > ans) ans = len;
				}
				else{       // If stack is empty. push current index as base for next valid substring (if any)
					s.push(i);
				}
			}
		}
		System.out.println(ans);
	}
}