/*
intuition for gap 2
str = c1 + m + c2
total palindromic subequences of str =  cnt(m) + cnt(c1m) + cnt(mc2) + cnt(c1mc2)
                                          s1        s2          s3           s4

total palindromic subequences of c1m = cnt(m) + cnt(c1m) => s1 + s2------i
total palindromic subequences of mc2 = cnt(m) + cnt(mc2) => s1 + s3 -----ii

*case when c1 != c2
total = s1 + s2 + s3 + 0
      = s1 + s2 + s3 + s1 - s1
      = (s1 + s2) + (s1 + s3) - s1
      = c1m + mc2 - m
-------------------------------------------------------------------------------------

*case when c1 == c2
eg aba (all subsequences)
s1 = _, b (_ is not considered as palindrome)
s2 = a _, ab
s3 =  _ a, ba
s4 = a _ a, aba
here we can observe that cnt of valid pailndrome in s1 => 1, s4 => 2 or we can say that s4 => s1 + 1
total = s1 + s2 + s3 + s4
    =  s1 + s2 + s3 + s1 + 1 
    = 1 + (s1 + s3) + (s1 + s2)
    = 1 + c1m + mc2; (from i $$ ii)
*/

import java.util.Scanner;
public class countPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int[][] dp = new int[s.length()][s.length()];
        scn.close();
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0 , j = gap; j < s.length(); j++, i++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } 
                else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                } 
                else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    } 
                    else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        System.out.println(dp[0][s.length() - 1]);
    }
}
