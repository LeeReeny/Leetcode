public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums){
        int rcd = 0;
        for(int n : nums){
            rcd ^= n;
        }
        int bit = rcd & (~rcd + 1);
        int a=0, b=0;
        for(int num : nums){
            if((num & bit) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
