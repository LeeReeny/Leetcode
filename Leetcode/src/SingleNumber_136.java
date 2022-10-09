public class SingleNumber_136 {
    public int singleNumber(int[] nums){
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }

    // 342 Power of four
    public boolean isPowerOfFour(int n){
        int cmp = 0xAAAAAAAA;
        return n > 0 && (n&(n-1))==0 && (n & cmp) != 0;
    }
}
