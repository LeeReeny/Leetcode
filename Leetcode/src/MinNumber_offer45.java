import java.util.Arrays;

public class MinNumber_offer45 {
    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; ++i){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y+x));
        StringBuilder res = new StringBuilder();
        for(String str : strs) res.append(str);
        return res.toString();
    }

    private int partition(String[] strs, int low, int high){
        String pivot = strs[high];
        int pointer = low;
        for(int i = low; i < high; ++i){
            if((strs[i]+pivot).compareTo(pivot+strs[i]) <= 0 ){
                String tmp = strs[i];
                strs[i] = strs[pointer];
                strs[pointer++] = tmp;
            }
        }
        String tmp = strs[pointer];
        strs[pointer] = strs[high];
        strs[high] = tmp;
        return pointer;
    }

    private void quicksort(String[] strs, int low, int high){
        if(low < high){
            int partition = partition(strs, low, high);
            quicksort(strs, low, partition-1);
            quicksort(strs, partition+1, high);
        }
    }
}
