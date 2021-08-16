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
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        helper(s, "", wordDict);
        return ans;
    }
}