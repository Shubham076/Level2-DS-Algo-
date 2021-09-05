//https://www.geeksforgeeks.org/shortest-common-supersequence/
public class shortestCommonSupersequence {
    static int[][] dp;
    public static int lcs(String s1, String s2){
        dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                char c = s1.charAt(i - 1);
                char d = s2.charAt(j - 1);

                if(c == d){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    } 

    public static String getlCS(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int i = m;
        int j = n;
        String lcs = "";
        while(i > 0 && j > 0){
            char c = s1.charAt(i - 1);
            char d = s2.charAt(j - 1);
            if(c == d){
                lcs = c + lcs;
                i--;
                j--;
            }
            else if(dp[i - 1][j] >= dp[i][j - 1]){
                i--;
            }
            else if(dp[i][j - 1] > dp[i - 1][j]){
                j--;
            }
        }
        return lcs;
    }


    //not completed
    public static String findSuperSequence(String s1, String s2, String lcs){
        int i = 0;
        int j = 0;
        int k = 0;
        String superSequence = "";
        while(k < lcs.length()){
            char c3 = lcs.charAt(k);

            while(i < s1.length()){
                char c1 = s1.charAt(i);
                if(c1 == c3) break;
                superSequence += c1;
                i++;
            }

            while(j < s2.length()){
                char c2 = s2.charAt(j);
                if(c2 == c3) break;
                superSequence += c2;
                j++;
            }

            superSequence += c3;
            i++;
            j++;
            k++;
        }
        while(i < s1.length()){
            char c = s1.charAt(i++);
            superSequence += c;
        }
        while(j < s2.length()){
            char c = s2.charAt(j++);
            superSequence += c;
        }
        return superSequence;
    }
    public static void main(String[] args){
        String s1 = "geek";
        String s2 = "eke";
        int len = lcs(s1, s2);
        String lcs = getlCS(s1, s2);
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("LCS: " + lcs);
        System.out.println("Length of smallest supersequence: " + (s1.length() + s2.length() - len));
    }
}
