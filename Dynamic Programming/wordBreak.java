
//leetcode 139
import java.util.*;

public class wordBreak {

    // recursion
    private boolean wb(String s, Set<String> dict) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); ++i) {
            if (dict.contains(s.substring(0, i)) && wb(s.substring(i), dict)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordbreak(String s, List<String> dict) {
        if (s == null || s.length() == 0)
            return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}