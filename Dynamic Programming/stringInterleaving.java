/*
leetcode 97
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty
substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

*/
import java.util.*;
public class stringInterleaving {

    //time complexity (2 ^ (m + n)) and space o(m + n);
    //recursion 
    static boolean solve1(String s1, String s2, String s3, int i, int j, int k){
        if(i == s1.length() && j == s2.length()){
            return true;
        }

        if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
            boolean temp = solve1(s1, s2, s3, i + 1, j, k + 1);
            if(temp == true) return true;
        }

        if(j < s1.length() && s3.charAt(k) == s2.charAt(j)){
            boolean temp = solve1(s1, s2, s3, i, j + 1, k + 1);
            if(temp == true) return true;
        }
        return false;
    }

    //recursion with memoization o(m * n)
    static boolean solve2(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp){
        if(i == s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }

        if(j == s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean ans = false;
        ans |= s3.charAt(k) == s1.charAt(i) && solve2(s1, s2, s3, i + 1, j, k + 1, dp);
        ans |= s3.charAt(k) == s2.charAt(j) && solve2(s1, s2, s3, i, j + 1, k + 1, dp);
        dp[i][j] = ans;
        return ans;
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        return solve2(s1, s2, s3, 0, 0, 0, dp);   
    }

    // tabulation meaning of dp[i][j] can 0 -> i - 1 chars of s1 and 0 -> j - 1 can combine to form a interleave equal to 0 -> i + j - 1
    //of s3 
    static boolean solve(String s1, String s2, String s3){
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0)
                    dp[i][j] = true;

                else if(i == 0)
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) ? dp[i][j - 1]: false;
                
                    else if(j == 0)
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) ? dp[i - 1][j]: false;
                
                    else{
                    if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                        dp[i][j] = dp[i - 1][j];
                    }

                    if(!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solve1(s1, s2, s3, 0, 0, 0));
        System.out.println(isInterleave(s1, s2, s3));
    }
}
