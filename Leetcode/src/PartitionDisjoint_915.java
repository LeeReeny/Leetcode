public class PartitionDisjoint_915 {
    public int partitionDisjoint(int[] nums){
        int left_max = nums[0];
        int idx = 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; ++i){
            max = Math.max(max, nums[i]);
            if(left_max > nums[i]){
                left_max = max;
                idx = i;
            }
        }
        return idx + 1;
    }
}
