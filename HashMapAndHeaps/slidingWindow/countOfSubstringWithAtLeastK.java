/*
count of substring with atleast k distinct characters
https://www.lintcode.com/problem/1375/
*/
import java.util.*;
public class countOfSubstringWithAtLeastK {
    static long method1(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() >= k) {
                cnt += s.length() - i;
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                j++;
            }
        }
        return cnt;
    }
    
    static long method2(String s, int k){
        int i = -1;
        int j = -1;
        long cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;

            while(i < s.length() - 1){
                i++;
                flag1 = true;
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if(map.size() >= k){
                    cnt += s.length() - i;
                    break;
                }
            }

            while(j < i){
                j++;
                flag2 = true;
                char c = s.charAt(j);
                int v = map.get(c);
                if(v > 1){
                    map.put(c, v - 1);
                }
                else{
                    map.remove(c);
                }

                if(map.size() >= k){
                    cnt += s.length() - i;
                }
                else if(map.size() < k){
					break;
				}
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        String s = "aabc";
        int k = 2;
        long ans1 = method1(s, k);
        long ans2 = method2(s, k);
        System.out.println(ans1 + " " + ans2);
    }
}
