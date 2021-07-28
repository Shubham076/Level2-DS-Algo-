/*
Given a string s which contains only lower alphabetic characters, check if it is possible to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string.
https://practice.geeksforgeeks.org/problems/check-frequencies4211/1
*/
import java.util.*;
public class ifFrequenciesCanBeEqual {
    static boolean sameFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i : map.values()){
            set.add(i);
        }

        if(set.size() > 2){
            return false;
        }
        else if(set.size() == 2){
            int a = -1;
            int b = -1;
            for(int i: set){
                if(a == -1){
                    a = i;
                }
                else{
                    b = i;
                }
            }
            if(a == 1 || b == 1){
                return true;
            }
            else if(Math.abs(a - b) == 1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }
}
