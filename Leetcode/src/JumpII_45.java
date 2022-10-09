public class JumpII_45 {
    public int jump(int[] nums){
        int size = nums.length;
        if(size == 1) return 0;
        if(size == 2) return 1;

        int i = 0, cnt = 1;
        while(i < size){
            if(i+nums[i] >= size-1) return cnt;
            int pos = i, localMax = 0;
            for(int j=i+1; j <= i+nums[i]; ++j){
                if(nums[j] >= localMax){
                    pos = j;
                    localMax = nums[j];
                }
            }
            i = pos;
            ++cnt;
        }
        return cnt;
    }

    public int jump_1(int[] nums){
        int cnt = 0;
        int end = 0, maxPos = 0;
        for(int i=0; i < nums.length-1; ++i){
            maxPos = Math.max(nums[i]+i, maxPos);
            if( i == end){
                end = maxPos;
                ++cnt;
            }
        }
        return cnt;
    }
}
