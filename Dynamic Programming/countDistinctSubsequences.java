/*
we have to count distinct subsequences.
abc
dp = [1, , , ];
map = {
    
}
subsequences of a are _, a
dp = [1,2, , ];
map = {
    a, 1
}
subsequences of ab =  _, a, b, ab
dp = [1, 2, 4,];
map = {
    a, 1,
    b, 2
}

subsequences of abb => _, a, b, ab, b, ab, bb, abb.
how to get the cnt of duplicates;
1: get the position of ch in map is seen previously i.e b = 2;
2: distinct = 8 - dp[index of b in map - 1] => 8 - 2 = 6;
*/
import java.util.HashMap;
import java.util.Scanner;
public class countDistinctSubsequences {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.close();
        int[] dp = new int[s.length() + 1];
        HashMap<Character , Integer> lo = new HashMap<>(); //character , index
        dp[0] = 1; 

        for(int i = 1; i < dp.length; i++){
            char c = s.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];

            if(lo.containsKey(c)){
                int j = lo.get(c);
                dp[i] = dp[i] - dp[j - 1];
            }

            lo.put(c , i);
        }
        System.out.println(dp[s.length()]);
    }
}
