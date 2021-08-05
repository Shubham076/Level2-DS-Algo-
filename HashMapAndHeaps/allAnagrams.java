//given two strings return count of p anagrams in string s  leetcode 438
import java.util.*;
public class allAnagrams {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String p = scn.nextLine();

        HashMap<Character, Integer> str = new HashMap<>();
        HashMap<Character, Integer> pat = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            pat.put(c, pat.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < p.length() - 1; i++){
            char c = s.charAt(i);
            str.put(c, str.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        int count = 0;
        for(int i = p.length() - 1; i < s.length(); i++){
            char d = s.charAt(i);
            str.put(d , str.getOrDefault(d, 0) + 1);

            if(pat.equals(str)){
                count++;
                ans.add((j));
            }
            char c = s.charAt(j);
            int val = str.get(c);
            if(val > 1){
                str.put(c, val - 1);
            }
            else{
                str.remove(c);
            }
            j++;
        }

        System.out.println(ans);
    } 
}
