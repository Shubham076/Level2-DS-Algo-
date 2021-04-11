import java.util.*;
public class Kanagrams {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String p = scn.nextLine();
        int k = scn.nextInt();
        

        if(s.length() != p.length()){
            System.out.println(false);
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        for(char c : p.toCharArray()){
            if(map.getOrDefault(c, 0) > 0){
                map.put(c , map.get(c) - 1);
            }
        }
        int count = 0;
        for(int i : map.values()){
            count += i;
        }

        if(count <= k){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
