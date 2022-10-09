public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] ary = new int[n+1];
        for(int i=0; i<n; i++){
            ary[nums[i]] = 1;
        }
        for(int j=0; j<n+1;j++){
            if(ary[j] == 0) return j;
        }
        return 0;
    }

    public int missingNumber_xor(int[] nums){
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
