import java.util.Scanner;
class longestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();

        int omax = 0;
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = 1 + max;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }
}