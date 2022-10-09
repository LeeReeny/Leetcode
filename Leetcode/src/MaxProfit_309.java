import java.util.concurrent.ArrayBlockingQueue;

public class MaxProfit_309 {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(len <= 1) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;          // 当天不持股且没卖出
        dp[0][1] = -prices[0]; // 当天持股
        dp[0][2] = 0;          // 当天卖出且不持股
        for(int i = 1; i < len; ++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }

        return Math.max(dp[len-1][0], dp[len-1][2]);
    }
}
