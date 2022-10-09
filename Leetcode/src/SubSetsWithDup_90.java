import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsWithDup_90 {
    public List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums){
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<Integer>());
        return ans;
    }
    public void backtracking(int[] nums, int level, List<Integer> path){
        ans.add(new ArrayList<>(path));
        for(int i = level; i < nums.length; ++i){
            if(i>level && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtracking(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }

}
