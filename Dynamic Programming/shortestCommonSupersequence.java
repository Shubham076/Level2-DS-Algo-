//https://www.geeksforgeeks.org/shortest-common-supersequence/
public class shortestCommonSupersequence {
    public static String lcs(String s1, String s2){
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                
                if( i == 0 || j == 0){
                    dp[i][j] = "";
                }
                else{
                    char c = s1.charAt(i - 1);
                    char d = s2.charAt(j - 1);    
                    if(c == d){
                        dp[i][j] = dp[i - 1][j - 1] + c;
                    }
                    else{
                        dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];   
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    public static String findSuperSequence(String s1, String s2, String lcs){
        int i = 0;
        int j = 0;
        int k = 0;
        String superSequence = "";
        while(k < lcs.length()){
            char c = lcs.charAt(k);

            while(s1.charAt(i) != c){
                superSequence += s1.charAt(i);
                i++;
            }

            while(s2.charAt(j) != c){
                superSequence += s2.charAt(j);
                j++;
            }

            superSequence += c;
            i++;
            j++;
            k++;
        }
        while(i < s1.length()){
            superSequence += s1.charAt(i++);
        }
        while(j < s2.length()){
            superSequence += s2.charAt(j++);
        }
        return superSequence;
    }
    public static void main(String[] args){
        String s1 = "geek";
        String s2 = "eke";
        String lcs = lcs(s1, s2);
        String superseq = findSuperSequence(s1, s2, lcs);
        System.out.println("LCS: " + lcs);
        System.out.println("Length of smallest supersequence: " + (s1.length() + s2.length() - lcs.length()));
        System.out.println("Supersequence: " + superseq);
    }
}
