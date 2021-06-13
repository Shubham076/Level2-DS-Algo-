/*
leetcode 1888 O(N) time and space
algorithm:
String s = "abc"
 n = s.length
 create a new string = s + s => "abcabc" 
 Now we can see that each and every window of size n is a valid rotation of string s;
 rotation of abc are = abc, bca, cab, abc all are present in the new string
 in this we solved the rotation of string part

 now create 2 alternating string of size n + n
*/
 import java.util.*;
class minimumFlipsToMakeBinaryStringEqual2{
	public static int minFlips(String s) {
		int n = s.length();
		String temp = s + s;
	/* 
		method for generating alternating strings starting from one and zero 
		we can use this loop for more readablity or easy understanding of code

		String one = "";   alternating string starting with 1
		// String zero = "";  alternating string starting with 0
		// for(int i = 0; i < 2 * n; i++){
		// 	one += (i % 2 == 0 ? '1': '0');
		// 	zero += (i % 2 == 0 ? '0': '1');

		in the solution below i have done the same work without generating the strings
	} */

		int diff1 = 0; // for mantaining the no of flips required to become alternating string starts with one 
		int diff2 = 0; // for mantaining the no of flips required to become alternating string starts with two
		int ans = Integer.MAX_VALUE;

		//sliding window
		for(int i = 0; i < n - 1; i++){
			char c = temp.charAt(i);
			if(c != (i % 2 == 0 ? '1': '0')){
				diff1++;
			}
			if(c != (i % 2 == 0 ? '0': '1')){
				diff2++;
			}
		}

		int j = 0;
		for(int i = n - 1; i < 2 * n; i++){
			char c = temp.charAt(i);
			if(c != (i % 2 == 0 ? '1': '0')){
				diff1++;
			}
			if(c != (i % 2 == 0 ? '0': '1')){
				diff2++;
			}

			ans = Math.min(ans, Math.min(diff1, diff2));
			//remove the effect of jth character and move the window
			char d = temp.charAt(j);
			if(d != (j % 2 == 0 ? '1': '0')){
				diff1--;
			}
			if(d != (j % 2 == 0 ? '0': '1')){
				diff2--;
			}
			j++;
		}
		return ans;
	}
	public static void main(String[] args){
		String s = "01001001101";
		System.out.println(minFlips(s));
	}
}



