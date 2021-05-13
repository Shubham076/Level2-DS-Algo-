//leetcode 821
public class shortestDistanceToACharacter {
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int j = -1;
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == c){
                ans[i] = 0;
                j = i;
            }
            else{
                ans[i] = Math.abs(i - j);
            }
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == c){
                j = i;
            }
            else{
                ans[i] = Math.min(ans[i], Math.abs(i - j));
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "loveleetcode";
        char c = 'e';
        int[] ans = shortestToChar(s, c);
        for(int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
    }    
}
