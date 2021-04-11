import java.util.*;
public class validAnagrams {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String p = scn.nextLine();
        if(p.length() != s.length()) return;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)  +1);
        }

        for(char c : p.toCharArray()){
            if(!map.containsKey(c)){
                return;
            }
            else if(map.get(c) == 1){
                map.remove(c);
            }
            else{
                map.put(c, map.get(c) - 1);
            }
        }
        boolean ans = map.size() == 0 ? true : false;
        System.out.println(ans); 
    }
}
