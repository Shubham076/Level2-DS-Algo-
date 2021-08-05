/*
https://practice.geeksforgeeks.org/problems/anagram-palindrome4720/1
if all the characters have even frequency than it is possible
how? just keep one character at the start and one at the end
if more than one character have odd freq than it is not possible
*/
class isAnagramPalindrome{
	boolean isPossible (String S){
		int[] arr = new int[256];
		for(int i = 0; i < S.length(); i++){
			char c = S.charAt(i);
			arr[c - 'a']++;
		}
		int cnt = 0;
		for(int i: arr){
			if(i % 2 != 0){
				cnt++;
			}
		}
		return cnt <= 1;
    }
}