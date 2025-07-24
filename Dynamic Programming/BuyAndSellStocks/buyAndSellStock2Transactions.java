package BuyAndSellStocks;

import java.util.Scanner;

class buyAndSellStock2Transactions {

    public int maxProfit(
        int[] prices,
        int i,
        int buy,
        int cap,
        Integer[][][] dp
    ) {
        if (cap == 0) return 0;
        if (i == prices.length) {
            // no more days left
            return 0;
        }
        if (dp[i][buy][cap] != null) return dp[i][buy][cap];
        int price;
        if (buy == 1) {
            price = Math.max(
                -prices[i] + maxProfit(prices, i + 1, 0, cap, dp),
                maxProfit(prices, i + 1, 1, cap, dp)
            );
        } else {
            price = Math.max(
                prices[i] + maxProfit(prices, i + 1, 1, cap - 1, dp),
                maxProfit(prices, i + 1, 0, cap, dp)
            );
        }
        return dp[i][buy][cap] = price;
    }

    public int memoization(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];
        return maxProfit(prices, 0, 1, 2, dp);
    }

    public int memoization2(int[] prices) {
        int n = prices.length;
        int k = 2;
        Integer[][] dp = new Integer[n][2 * k];
        return maxProfit2(prices, 0, 0, 2 * k, dp);
    }

    public int maxProfit2(
        int[] prices,
        int i,
        int tranNo,
        int k,
        Integer[][] dp
    ) {
        if (i == prices.length || tranNo == k) {
            // no more days left
            return 0;
        }
        if (dp[i][tranNo] != null) return dp[i][tranNo];
        int price;
        if (tranNo % 2 == 0) {
            // means buy
            price = Math.max(
                -prices[i] + maxProfit2(prices, i + 1, tranNo + 1, k, dp),
                maxProfit2(prices, i + 1, tranNo, k, dp)
            );
        } else {
            price = Math.max(
                prices[i] + maxProfit2(prices, i + 1, tranNo + 1, k, dp),
                maxProfit2(prices, i + 1, tranNo, k, dp)
            );
        }
        return dp[i][tranNo] = price;
    }

    public int tabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 1; c <= 2; c++) {
                    if (b == 1) {
                        dp[i][b][c] = Math.max(
                            -prices[i] + dp[i + 1][0][c],
                            dp[i + 1][1][c]
                        );
                    } else {
                        dp[i][b][c] = Math.max(
                            prices[i] + dp[i + 1][1][c - 1],
                            dp[i + 1][0][c]
                        );
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        //max profit left agr aj sell krna mandatory h
        int mpl = 0;
        int[] dpl = new int[n];
        int lsf = arr[0]; //least so far

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < lsf) {
                lsf = arr[i];
            }

            mpl = arr[i] - lsf;
            if (mpl > dpl[i - 1]) {
                dpl[i] = mpl;
            } else {
                dpl[i] = dpl[i - 1];
            }
        }

        //max profit right agr buy krna mandatory h
        int mpr = 0;
        int msf = arr[n - 1]; //max so far
        int[] dpr = new int[n];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > msf) {
                msf = arr[i];
            }

            mpr = msf - arr[i];
            if (mpr > dpr[i + 1]) {
                dpr[i] = mpr;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }

        int op = 0; //overall profit
        for (int i = 0; i < arr.length; i++) {
            if (dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }
        System.out.println(op);
    }
}
