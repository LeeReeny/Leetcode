public class CountBits_338 {
    public int[] countBits(int n){
        int[] ans = new int[n+1];
        for(int i=0; i <= n; i++){
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    public int[] countBits_dp(int n){
        int[] dp = new int[n+1];
        for(int i=1; i<= n; i++){
            dp[i] = (i&1) == 1 ? dp[i-1]+1 : dp[i>>1];
        }
        return dp;
    }
}
