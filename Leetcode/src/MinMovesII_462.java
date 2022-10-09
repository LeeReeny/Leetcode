import java.util.Arrays;

public class MinMovesII_462 {
    public int minMoves2(int[] nums){
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int val = nums[nums.length / 2];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += Math.abs(nums[i] - val);
        }
        return ans;
    }
}
