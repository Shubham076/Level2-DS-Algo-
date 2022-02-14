7//leetcode 93
import java.util.*;
public class restoreIpAddress {

    static boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        if(Integer.parseInt(s) > 255) return false;
        return true;
    }

    //cleaner code
    static void helper2(int i, int p, String s, String cur, List<String> ans){
        if(p > 4) return;

        if(i == s.length()){
            if(p == 4){
                ans.add(cur.substring(0, cur.length() - 1));
            }
            return;
        }
        for(int j = 1; j <= 3; j++){
            if(i + j <= s.length() && isValid(s.substring(i, i + j))){
                helper2(i + j, p + 1, s, cur + s.substring(i, i + j) + ".", ans);        
            }
        }
    }
    static void helper(int i, int p, String s, String cur, List<String> ans){
        if(p > 4) return;
        if(i == s.length()){
            if(p == 4){
                ans.add(cur.substring(0, cur.length() - 1));
            }
            return;
        }
        helper(i + 1, p + 1, s, cur + s.charAt(i) + ".", ans);

        if(i + 2 <= s.length() && isValid(s.substring(i, i + 2)))
            helper(i + 2, p + 1, s, cur + s.substring(i, i + 2) + ".", ans);

        if(i + 3 <= s.length() && isValid(s.substring(i, i + 3)))
            helper(i + 3, p + 1, s, cur + s.substring(i, i + 3)+ ".", ans);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, s, "", ans);
        return ans;
    }
    public static void main(String[] args){
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
