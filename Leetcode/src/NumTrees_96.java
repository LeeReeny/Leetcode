public class NumTrees_96 {
    public int numTress(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n <= 1) return dp[n];
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < n; ++j){
                dp[i] += dp[j]*dp[n-1-j];
            }
        }
        return dp[n];
    }
}
