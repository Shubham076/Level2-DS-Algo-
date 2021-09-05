/*
leetcode 115
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It is guaranteed the answer fits on a 32-bit signed integer.

meaning of dp[i][j] => number of distinct subsequences of s[0...i] equal to substring t[0...j]
eg => s = abb, t = bab
base cases 
when i = 0,j = 0 means(_ and _) one subsequence of _ is equal to string s => 1
when i == 0 && j != 0  dp[i][j] = 0 as there is no subsequence of _ that is equal to _b, _ba, _bab
when i != 0 && j == 0 dp[i][j] = 1 as there is always a susequence of  _a, _ab, abb == _ 


now a subsequence has 2 choices when last character is added or not added
when last 2 char are equal
dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]  2 choices last char included or not

when last 2 char are not equal
dp[i][j] = dp[i - 1][j]
*/
public class distinctSubsequences2 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                char c = s.charAt(i - 1);
                char d = t.charAt(j - 1);
                if(c == d){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
