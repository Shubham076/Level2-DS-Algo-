//leetcode 387 or first unique character
public class firstNonRepetingCharacter {
    //O(N + N)
    public static int firstUniqChar(String s) {
        int[] freq = new int[256];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i);
            if(freq[c] == 1) return i;
        }   
        return -1;
    }

    static class Pair{
        int f;
        int i;
    }

    //O(N + 256)
    public static int firstUniqChar2(String s){
        Pair[] f = new Pair[256];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(f[c] == null) f[c] = new Pair();
            f[c].f++;
            f[c].i = i;
        }

        int ans = Integer.MAX_VALUE;
        for(Pair p: f){
            if(p != null && p.f == 1 && p.i < ans){
                ans = p.i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "LLeett()code";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar2(s));
    }
}
