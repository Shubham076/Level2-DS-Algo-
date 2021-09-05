//s.lemgth() - length of longest palindromice subsequence
//same logic for in deletions 
package StringManipulation;
public class minAdditionToMakeStringPalindrome {
    public static void main(String[] args){
        String s = "shubham";
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int i = 0,j = gap; j < n; j++,i++){
                if(gap == 0){
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j - 1] );
                    }
                }
            }
        }
        System.out.println(n - dp[0][n - 1]);
    }
}
