public class IntegerBreak_343 {
    public int integerBreak(int n){
        int a = (int) Math.pow(10,n);
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        if(n <= 2) return dp[n];
        for(int i = 3; i <= n; ++i){
            int res = 0;
            for(int j = 1; j < i; ++j){
                int tmp = Math.max(j*(i-j), j*dp[i-j]);
                res = Math.max(tmp, res);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
