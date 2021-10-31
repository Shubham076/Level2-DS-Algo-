/*
leetcode 205
one to one mapping between characters
*/
import java.util.*;
public class isomorphicStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String t = scn.nextLine();
        if(s.length() != t.length()){
            return;
        }
        HashMap<Character, Character> map1 = new HashMap<>(); //stores the mapping
        HashMap<Character, Boolean> map2 = new HashMap<>();  //stores whether the char of t is used or not
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char d = t.charAt(i);

            if(map1.containsKey(c)){
                if(map1.get(c) != d)
                    return;
                else{
                    continue;
                }
            }
            else{
                if(map2.containsKey(d) && map2.get(d)){
                    return;
                }
                else{
                    map1.put(c , d);
                    map2.put(d , true);
                }
            }

        }
        System.out.println(true);
    }
}
