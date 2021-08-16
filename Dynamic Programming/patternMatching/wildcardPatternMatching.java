import java.util.Scanner;

public class wildcardPatternMatching {

    public static boolean match(String s ,  String p){
        boolean[][] dp = new boolean[p.length() + 1][s.length() +1];
        for(int j = dp[0].length - 1 ; j >= 0; j--){
            for(int i = dp.length - 1 ; i >= 0; i--){

                if(j == dp[0].length - 1 && i == dp.length - 1){
                    dp[i][j] = true;
                }
                else if(j == dp[0].length - 1){

                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i + 1][j];
                    }
                    else{
                        dp[i][j] = false;
                    }
                } 
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
        
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String p = scn.next();
        System.out.println(match(s, p));


    }


}
