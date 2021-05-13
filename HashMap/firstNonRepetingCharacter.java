//leetcode 387 or first unique character
public class firstNonRepetingCharacter {
    public static int firstUniqChar(String s) {
        int[] freq = new int[256];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - '0']++;
        }
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - '0';
            if(freq[c] == 1) return i;
        }
        
        return -1;
    }
    public static void main(String[] args){
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
