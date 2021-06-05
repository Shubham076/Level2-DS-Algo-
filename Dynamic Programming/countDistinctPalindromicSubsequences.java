//very important
import java.util.HashMap;
import java.util.Scanner;

public class countDistinctPalindromicSubsequences {
 public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String s= scn.next();
    int[] prev = new int[s.length()];
    int[] next = new int[s.length()];
    HashMap<Character , Integer> map = new HashMap<>();
    
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(!map.containsKey(c)){
            prev[i] = -1;
        }
        else{
            prev[i] = map.get(c);
        }

        map.put(c , i);
    }

    map.clear();

    for(int i = s.length() - 1; i >= 0; i--){
        char c = s.charAt(i);
        if(!map.containsKey(c)){
            next[i] = -1;
        }
        else{
            next[i] = map.get(c);
        }

        map.put(c , i);
    }

    int[][] dp = new int[s.length()][s.length()];

    for(int gap = 0; gap < s.length(); gap++){
        for(int i = 0,j = gap; j < s.length(); j++,i++){
            if(gap == 0){
                dp[i][j] = 1;

            }
            else if(gap == 1){
                dp[i][j] =  2;
            }
            else{
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                else{
                    int n = next[i];
                    int p = prev[j];
                    if(n > p){
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    }
                    else if(n == p){
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    }
                    else{
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[n + 1][p - 1];
                    }
                }
            }
        }
    }

    System.out.println(dp[0][s.length() - 1]);
     scn.close();
 }   
}
