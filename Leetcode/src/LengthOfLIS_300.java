import java.util.Arrays;

public class LengthOfLIS_300 {
    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        if(len == 0 || len == 1) return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j <= i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return dp[len-1];
    }
}
