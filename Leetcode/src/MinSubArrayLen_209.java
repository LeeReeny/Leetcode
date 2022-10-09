import java.util.HashMap;

public class MinSubArrayLen_209 {
    public int minSubArrayLen(int target, int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=0; i < nums.length; i++){
            int sum = 0;
            for(int j=i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target){
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen_1(int target, int[] nums){
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= target){
                min = Math.min(min, end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
