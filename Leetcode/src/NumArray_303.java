public class NumArray_303 {
    class NumArray{

        int[] sumAry;

        public NumArray(int[] nums){
            int n = nums.length;
            sumAry = new int[n+1];
            for(int i=1; i<n+1; i++){
                sumAry[i] = sumAry[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right){
            return sumAry[right+1] - sumAry[left];
        }
    }
}
