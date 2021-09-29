import java.util.*;
//count of substring with atleast k distinct characters
public class countOfSubstringWithAtLeastK {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int k = scn.nextInt();
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
        System.out.println(cnt);
    }
}
