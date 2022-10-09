import java.util.Random;

public class FindKthLarge_076 {
    Random RANDOM = new Random();
    public int findKthLarge(int[] nums, int k){
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        int pivot_pos = getPivot(nums, left, right);
        while(pivot_pos != target){ // 二分查找
            if(pivot_pos > target) right = pivot_pos - 1;
            else left = pivot_pos + 1;
            pivot_pos = getPivot(nums, left, right);
        }
        return nums[pivot_pos];
    }

    public int getPivot(int[] nums, int left, int right){ //获取pivot元素排序后的下标
        // [left, right]中随便选取一个数，防止数组基本有序的情况下快排失效
        int random = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, random, right);  // 先把pivot元素放到数组右端
        int idx = left - 1;
        for(int  i = left; i < right; ++i){
            if(nums[i] < nums[right]){
                swap(nums, i, ++idx);
            }
        }
        swap(nums, right, ++idx);
        return idx;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
