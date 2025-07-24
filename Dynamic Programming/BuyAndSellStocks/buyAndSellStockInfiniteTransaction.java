import java.util.Scanner;

public class buyAndSellStockInfiniteTransaction {

    public int maxProfit(int[] prices, int i, int buy, int[][] dp) {
        if (i == prices.length) {
            // no more days left
            return 0;
        }
        if (dp[i][buy] != -1) return dp[i][buy];
        int price;
        if (buy == 1) {
            price = Math.max(
                -prices[i] + maxProfit(prices, i + 1, 0, dp),
                maxProfit(prices, i + 1, 1, dp)
            );
        } else {
            price = Math.max(
                prices[i] + maxProfit(prices, i + 1, 1, dp),
                maxProfit(prices, i + 1, 0, dp)
            );
        }
        return dp[i][buy] = price;
    }

    public int memoization(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return maxProfit(prices, 0, 1, dp);
    }

    public int tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b <= 1; b++) {
                if (b == 1) {
                    dp[i][b] = Math.max(
                        -prices[i] + dp[i + 1][0],
                        dp[i + 1][1]
                    );
                } else {
                    dp[i][b] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    // space optimized
    public int spaceOptimizedTabulation(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] cur = new int[2];
        ahead[0] = ahead[1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b <= 1; b++) {
                if (b == 1) {
                    cur[b] = Math.max(-prices[i] + ahead[0], ahead[1]);
                } else {
                    cur[b] = Math.max(prices[i] + ahead[1], ahead[0]);
                }
            }
            ahead = cur;
        }
        return ahead[1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int sd = 0; //sold day
        int bd = 0; // bought day
        int p = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                sd++;
            } else {
                //collecting the profit
                p += arr[sd] - arr[bd];
                bd = sd = i;
            }
        }
        // case [1, 2, 3, 4, 5] means each and every day price is increasing
        p += arr[sd] - arr[bd];
        System.out.println(p);
    }
}
