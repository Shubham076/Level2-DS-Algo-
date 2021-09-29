/*  leetcode 1234
logic is that we check frequency map of remaining characters other than the window
if any charater has freq > n / 4 then we cant replace that window
otherwise we store the answer and look for the smaller answer by decreasing the size of
the window
 */
import java.util.*;
public class replaceSubstringForBalancedString {
    public static boolean isValid(HashMap<Character, Integer > map, int n){
        for(int i : map.values()){
            if(i > n / 4){
                return false;
            }
        }
        return true;
    }
    public static int balancedString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.get(c) - 1);

            while(j < s.length() && isValid(map, s.length())){
                if(j > i){
                    //means i ne jitne remove kie j ne utne add krdie (already balanced)
                    return 0;
                }
                int curLen = i - j + 1;
                ans = Math.min(ans, curLen);
                char d = s.charAt(j);
                map.put(d, map.getOrDefault(d, 0) + 1);
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "QWER";
        int ans = balancedString(s);
        System.out.println(ans);
    }
}
