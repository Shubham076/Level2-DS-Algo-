//leetcode 131
import java.util.*;
class palindromePartioning{
	public static List<List<String>> partition(String s) {
        boolean[][] storage = new boolean[s.length()][s.length()];
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

		for(int gap = 0; gap < s.length(); gap++){
			for(int i = 0, j = gap; j < s.length(); j++, i++){
				if(gap == 0){
					storage[i][j] = true;
				}
				else if(gap == 1){
					storage[i][j] = s.charAt(i) == s.charAt(j);
				}
				else{
					storage[i][j] = s.charAt(i) == s.charAt(j) && storage[i + 1][j - 1];
				}
			}
        }
         helper(ans, temp, storage, s, 0);
        return ans;
    }
    
    private static void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
	public static void main(String[] args) {
		String s = "bbab";
		System.out.println(partition(s));
	}
}