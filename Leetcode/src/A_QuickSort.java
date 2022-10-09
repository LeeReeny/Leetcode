import java.util.Arrays;

public class A_QuickSort {
    public int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int pointer = low; // 指向比pivot元素大的指针
        for(int i = low; i < high; ++i){
            if(nums[i] <= pivot){
                int tmp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = tmp;
                pointer++;
            }
        }
        int tmp = nums[pointer];
        nums[pointer] = nums[high];
        nums[high] = tmp;
        return pointer;
    }

    public void quicksort(int[] nums, int low, int high){
        if(low < high){
            int position = partition(nums, low, high);

            quicksort(nums, low, position-1);
            quicksort(nums, position+1, high);
        }
    }
}
