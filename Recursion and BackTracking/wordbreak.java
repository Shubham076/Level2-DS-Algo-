//leetcode 140
import java.util.*;
public class wordbreak{
    static List<String> ans;
    public static void helper(String s, String temp, List<String> dict){
        for(int i = 0; i <= s.length(); i++){
            String prefix = s.substring(0, i);

            if(dict.contains(prefix)){
                //no more elements left
                if(i == s.length()){
                    temp += prefix;
                    ans.add(temp);
                    return;
                }
                helper(s.substring(i), temp + prefix + " ", dict);
            }
        }   
    }
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
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        helper(s, "", wordDict);
        return ans;
    }
}