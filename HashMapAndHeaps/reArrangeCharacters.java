/*
https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
Given a string with repeated characters, the task is to rearrange characters in a string so
that no two adjacent characters are same.
Note : It may be assumed that the string has only lowercase English alphabets.

if we want to re arrange such that no 2 character are same
first thing came to mind that we should arrange character with max frequency
*/
import java.util.*;
public class reArrangeCharacters {
    static class Pair{
        char c;
        int f;
        Pair(char c, int f){
            this.c = c;
            this.f = f;
        }
    }
    static boolean isItPossibleToReArrange(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.f - a.f);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char k: map.keySet()){
            pq.add(new Pair(k, map.get(k)));
        }
        Pair blacklist =  pq.remove();
        String ans = "";
        ans += blacklist.c;
        blacklist.f -= 1;
        
        while(pq.size() > 0){
            Pair rm = pq.remove();
            ans += rm.c;
            rm.f -= 1;
            
            if(blacklist.f > 0)
                pq.add(blacklist);
            blacklist = rm;
        }
        if(ans.length() != s.length()){
            System.out.println("Not Possible");
            return false;
        }
        else{
            System.out.println(ans);
            return true;
        }
    }
    public static void main(String[] args){
        String s = "aaabbc";
        isItPossibleToReArrange(s);
    }
}
