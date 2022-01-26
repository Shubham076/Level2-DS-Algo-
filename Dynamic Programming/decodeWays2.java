/*
leetcode 639
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above
(there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

In addition to the mapping above, an encoded message may contain the '*' character,
which can represent any digit from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the
encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

Given a string s consisting of digits and '*' characters, return the number of ways to decode it.

Since the answer may be very large, return it modulo 109 + 7.
*/
class decodeWays2 {
	public static void main(String[] args) {
		String S = "*0";
		int n = S.length();
		long[] dp = new long[n];
		char a = S.charAt(0);
		if (a == '*') {
			dp[0] = 9;
		} 
		else if (a == '0') {
			dp[0] = 0;
		} 
		else {
			dp[0] = 1;
		}
		int m = (int)1e9 + 7;
		for (int i = 1; i < n; i++) {
			char f = S.charAt(i - 1);
			char s = S.charAt(i);

			//case 1:
			if (f == '*' && s == '*') {
				/*
				2** 2 ways => 2* - *  => since * can take (1 - 9) => 9 * ways to encode(2*);
				           => 2 - ** => posiible com for ** => cnt(11...19, 21...26) * ways(2) => 15 * ways to encode (2);
				*/
				dp[i] = (9 * dp[i - 1] + 15 * (i >= 2 ? dp[i - 2] : 1)) % m;
			}

			/*  case 2:  2*1   here s = 1
			ways(2 - *1) =>  (s<= 6)  * can take only value (1 and 2) => 2 * ways(2);
						 => s(7 ... 9) * can take only one value(1)

			ways(2* - 1) => s == 0 ? 0 : 9 * ways(2*)
			*/
			else if (f == '*' && s != '*') {
				if (s == '0') {
					dp[i] = (2 * (i >= 2 ? dp[i - 2] :  1)) % m;
				} 
				else if (s >= '1' && s <= '6') {
					dp[i] = dp[i - 1] + (2 * (i >= 2 ? dp[i - 2] :  1)) % m;
				}
				else {
					dp[i] = dp[i - 1] +  (i >= 2 ? dp[i - 2] : 1);
				}
			}

			/* case 3  22* here f = 2 and s = *
			     ways (2 - 2*) => (f = 1) =>  cnt(11.... 19) * ways(2)  => 9 * ways (2);
			     ways (2 - 2*) => (f = 2) =>  cnt(21....26) * ways(2)  => 6 * ways (2);
			     ways(22 - *) => 9 * ways(22);
			*/
			else if (f != '*' && s == '*') {
				if (f == '1') {
					dp[i] =  (9 * dp[i - 1] + 9 * (i >= 2 ? dp[i - 2] : 1)) % m;
				}
				else if (f == '2') {
					dp[i] =  (9 * dp[i - 1] + 6 * (i >= 2 ? dp[i - 2] : 1)) % m;
				} 
				else {
					dp[i] = (9 * dp[i - 1]) % m;
				}
			}

			//case 4
			else if (f != '*' && s != '*') {

				//subcase 1: 200 -> ways(2-00) + ways(20- 0) => 0  (there is no encoding for 0 and 00)
				if (f == '0' && s == '0') {
					dp[i] = 0;
				}
				// subcase 2: 220 -> ways(2 - 20) + ways(22 - 0);
				else if (f != '0' && s == '0') {
					if (f == '1' || f == '2') {
						dp[i] = (i >= 2 ? dp[i - 2] : 1);
					} 
					else dp[i] = 0;
				}

				//subcase 3:  202 => ways(2- 02) + ways(20 - 2); (no encoding for 02);
				else if (f == '0' && s != '0') {
					dp[i] = dp[i - 1];
				}

				//subcase 4:  232 => ways(2 - 32) + ways(23 - 2);
				else if (f != '0' && s != '0') {
					if (Integer.parseInt(S.substring(i - 1, i + 1)) <= 26) {
						dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
					} else dp[i] = dp[i - 1];
				}
			}
		}
		System.out.println(dp[n - 1]);
	}
}