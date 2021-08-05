import java.util.Scanner;
public class longestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        char[] x = s1.toCharArray();
        String s2 = scn.next();
        char[] y  = s2.toCharArray();
        scn.close();
        lcsDp(x, y, s1.length(), s2.length());        
    }
    
    public static int lcsDp(char[] x, char[] y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                }
                else if (x[i - 1] == y[j - 1]) {
                    L[i][j] = 1 + L[i - 1][j - 1];

                }
                else {
                    L[i][j] = (int) Math.max(L[i][j - 1], L[i - 1][j]);
                }
            }
        }
        return L[m][n];
    }
}
