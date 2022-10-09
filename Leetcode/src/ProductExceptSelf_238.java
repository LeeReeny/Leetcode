public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i = 1; i < n; i++){
            left[i] = nums[i-1] * left[i-1];
        }
        for(int j = n-2; j >= 0; j--){
            right[j] = right[j+1] * nums[j+1];
        }
        int[] ans = new int[n];
        for(int k = 0; k < n; k++){
            ans[k] = left[k] * right[k];
        }
        return ans;
    }
}
