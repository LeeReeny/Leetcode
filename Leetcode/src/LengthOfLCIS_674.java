import java.util.Arrays;

public class LengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums){
        int len = nums.length;
        if(len == 1) return 1;
        int[] dp = new int[len];
        Arrays.fill(nums, 1);
        int res = 1;
        for(int i = 1; i < len; ++i){
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int findLengthOfLCIS_1(int[] nums){
        int len = nums.length;
        if(len == 1) return 1;
        int start = 0, res = 1;
        for(int i = 1; i < len; ++i){
            if(nums[i] <= nums[i-1]) start = i;
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
