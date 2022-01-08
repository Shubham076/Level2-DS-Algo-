//finding longest palindromic substring in o(n) time
class manachersAlgorithm{

	// adds hash after every character and first and last charcater
	//eg = "abc" => "@#a#b#c#&"
	static String encode(String s){
		StringBuilder sb = new StringBuilder("@#");
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			sb.append(c + "#");
		}
		sb.append("$");
		return sb.toString();
	}

	//removes hash from each chracter eg ="#a#b" => "ab"
	static String decode(String s){
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c != '#'){
				sb.append(c);
			}
		}
		return sb.toString();
	}

	// O(n * n)
	static String method1(String str){
		String s = encode(str);
		int[] lps = new int[s.length()];
		String ans = "";
		int cnt = 0;
		for(int i = 2; i < s.length() - 2; i++){
			//assuming each and every character as center of palindrome and calculating the max len 
			while(s.charAt(i + lps[i] + 1) == s.charAt(i - lps[i] - 1)){
				lps[i]++;
			}
			if(lps[i] > cnt){
				cnt = lps[i];
				ans = s.substring(i - lps[i] , i + lps[i] + 1);
			}
		}
		return decode(ans);
	}

	//O(n)
	static String manacher(String str){
		String s = encode(str);
		int[] lps = new int[s.length()];
		String ans = "";
		int cnt = 0;
		int c = 0; // center of the window
		int r = 0; // index of the last known character or last idx of window with c as center of window
		for(int i = 2; i < s.length() - 2; i++){

			int mirr = c - (i - c); // calculating the mirror of ith character assuming cth idx as center
			/*
		   eg(idx)  0 1 2 3 4 5 6
               lps  1 2 2 2 3 2 0
			   c = 2 
			   => lps[c] = 2 means we known area from 0 => 4 =>  r = 4
			   i is at 3 
			   mirror of i = 1 => c - (i - c) => 2 - (3 - 2) => 1
			*/

			if(i < c){
				/*	
					if current idx lies inside known area we can kickstart instead of starting from scratch
					why min? because let us assume that lps[mirr] = 4; and the distance between r(known area - ith idx) < 4
					so i cant say anything for 4 but i can kickstart with value 3
				*/
				lps[i] = Math.min(lps[mirr], r - c);
			}

			//assuming each and every character as center of palindrome and calculating the max len 
			while(s.charAt(i + lps[i] + 1) == s.charAt(i - lps[i] - 1)){
				lps[i]++;
			}

			//calculating ans
			if(lps[i] > cnt){
				cnt = lps[i];
				ans = s.substring(i - lps[i] , i + lps[i] + 1);
			}

			//expanding the range and changing the center
			if(i + lps[i] > r){
				c = i;
				r = i + lps[i];
			}
		}
		return decode(ans);	
	}
	public static void main(String[] args){
		String s = "forgeeksskeegfor";
		String ans1 = method1(s);
		String ans2 = manacher(s);
		System.out.println(ans1);
		System.out.println(ans2);
	}
} 