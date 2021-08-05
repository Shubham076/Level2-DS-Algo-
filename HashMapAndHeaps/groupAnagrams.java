//group all the strings having smae freq map
import java.util.*;
public class groupAnagrams {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        String[] s = new String[n];
        for(int i = 0; i < n; i++){ 
            s[i] = scn.next();
        }

        for(String a : s){
            HashMap<Character, Integer> freq = new HashMap<>();
            for(int i = 0; i < a.length(); i++){
                char c = a.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0 ) + 1);
            }

            if(map.containsKey(freq)){
                ArrayList<String> strs = map.get(freq);
                strs.add(a);
                map.put(freq, strs);
            }
            else{
                ArrayList<String> strs = new ArrayList<>();
                strs.add(a);
                map.put(freq, strs); 
            }
        }

        for(ArrayList<String> strs : map.values()){
            ans.add(strs);
        }
        System.out.println(ans);
    }
}
