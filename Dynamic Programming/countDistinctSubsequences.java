import java.util.HashMap;
import java.util.Scanner;
public class countDistinctSubsequences {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.close();
        int[] dp = new int[s.length() + 1];
        HashMap<Character , Integer> lo = new HashMap<>();
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){
            char c = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];

            if(lo.containsKey(c)){
                int j = lo.get(c);
                dp[i] = dp[i] - dp[j - 1];
            }

            lo.put(c , i);
        }
        System.out.println(dp[s.length()]);
    }
}
