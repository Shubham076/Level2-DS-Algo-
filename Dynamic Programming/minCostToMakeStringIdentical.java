import java.util.*;
class minCostToMakeStringIdentical{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		char[] x = s1.toCharArray();
        char[] y  = s2.toCharArray();
        int c1 = scn.nextInt();
        int c2 = scn.nextInt();
        scn.close();
        int len = lcsDp(x, y, s1.length(), s2.length());
        int tc = c1 * (s1.length() - len) + c2 * (s2.length() - len);
        System.out.println(len);

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