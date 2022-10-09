import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        List<Integer> nums_list = new ArrayList<>();
        for(int n : nums) nums_list.add(n);
        backtracking(nums_list, 0, ans);
        return ans;
    }

    public void backtracking(List<Integer> nums, int level, List<List<Integer>> ans){
        if(level == nums.size()-1){
            ans.add(new ArrayList<>(nums));
            return;
        }

        for(int i=0; i<nums.size(); ++i){
            int tmp1 = nums.get(i);
            nums.set(i, nums.get(level));
            nums.set(level, tmp1);
            backtracking(nums, level+1, ans);
            int tmp2 = nums.get(i);
            nums.set(i, nums.get(level));
            nums.set(level, tmp2);
        }
    }



}
