import java.util.*;
class romanToInteger{
	public static int romanToInt(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ans += map.get(c);

            if(i > 0 && map.get(c) > map.get(s.charAt(i - 1))){
                ans -= 2 * map.get(s.charAt(i - 1));  
            }                       
        }

        return ans;
    }
	public static void main(String[] args) {
		String s = "MCMXCIV";
		System.out.println(romanToInt(s));
	}
}