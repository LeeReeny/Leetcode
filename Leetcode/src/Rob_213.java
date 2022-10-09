public class Rob_213 {
    public int rot(int[] nums){
        int len = nums.length;
        if(len == 1) return nums[0];

        int[] dp = new int[len+2];

        //不偷最后一个房间
        for(int i = 2; i < len + 1; ++i){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-2]);
        }
        int preMax = dp[len];
        dp[2] = 0;
        // 不偷第一个房间
        for(int i = 3; i < len + 2; ++i){
            dp[i] =  Math.max(dp[i-1], dp[i-2]+nums[i-2]);
        }
        return Math.max(preMax, dp[len+1]);
    }
}
