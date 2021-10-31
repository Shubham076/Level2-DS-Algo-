/*
leetcode 44
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
*/
import java.util.Scanner;
public class wildcardPatternMatching {
    static boolean method1(String s, String p){
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                //_ cant match any character
                else if(i == 0){
                    dp[i][j] = false;
                }

                /*
                    * becomes blank so pattern reduced by one and string remains same
                    so we use the answer of row + 1
                */
                else if(j == 0){
                    if(p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                else{

                    if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                /*
                    string  = "abab"
                    pat =    "aa*"
                    * has 2 possible choices:
                    * becomes blank => problem reduces to can "aa" matches "abab" => dp[i - 1][j]
                    or * consumes b and still remains => problem reduces to can "aa*" matches "aba" => dp[i][j - 1]
                */

                    if(p.charAt(i - 1) == '*'){
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static boolean method2(String s ,  String p){
        boolean[][] dp = new boolean[p.length() + 1][s.length() +1];
        for(int j = dp[0].length - 1; j >= 0; j--){
            for(int i = dp.length - 1; i >= 0; i--){

                //_ matches with _
                if(j == dp[0].length - 1 && i == dp.length - 1){
                    dp[i][j] = true;
                }

                else if(j == dp[0].length - 1){

                    /*
                    * becomes blank so pattern reduced by one and string remains same
                    so we use the answer of row + 1
                    */
                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i + 1][j];
                    }
                    else{
                        dp[i][j] = false;
                    }
                } 
                //last row => _ cant match any character
                else if( i == dp.length - 1){
                    dp[i][j] = false;
                }

                else{

                    if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
                        dp[i][j] = dp[i + 1][j + 1];
                    }

                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(method2(s, p));
        System.out.println(method1(s, p));
    }
}
