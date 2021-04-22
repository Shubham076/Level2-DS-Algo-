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

                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        System.out.println(dp[0][s.length() - 1]);
    }
}
