public class MoveZeros_283 {
    public void moveZeros(int[] nums){
        if(nums.length <= 1) return;
        int j = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                int tmp =nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
