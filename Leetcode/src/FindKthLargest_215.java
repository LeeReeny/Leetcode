public class FindKthLargest_215 {
    public int quickSelect(int[] nums, int l, int r){
        int i = l+1, j = r;
        while(true){
            while(i<r && nums[i] <= nums[l]) i++;
            while(j>l && nums[j] >= nums[l]) j--;
            if(i >=j ) break;
            int tmp = nums[i]; // swap(nums[i], nums[j])
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[j]; // swap(nums[l], nums[j])
        nums[j] = nums[l];
        nums[l] = tmp;
        return j;
    }

    public int findKthLargest(int[] nums, int k){
        int l = 0, r = nums.length-1, target = nums.length - k;
        while(l < r){
            int mid = quickSelect(nums, l, r);
            if(mid == target) return nums[mid];
            if(mid < target) l = mid + 1;
            else r = mid - 1;
        }
        return nums[l];
    }
}
