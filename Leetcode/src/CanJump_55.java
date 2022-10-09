public class CanJump_55 {
    public boolean canJump(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(i+nums[i] >= nums.length-1) return true;
            int pos = i, localMax = i+nums[i];
            for(int j=i; j<=i+nums[i]; ++j){
                if(j+nums[j] > localMax){
                    pos = j;
                    localMax = j+nums[j];
                }
            }
            i = pos;
        }
        return false;
    }

    public boolean canJump_1(int[] nums){
        int k = 0;
        for(int i=0; i<nums.length; ++i){
            if(i > k) return false;
            k = Math.max(k, i+nums[i]);
        }
        return true;
    }
}
