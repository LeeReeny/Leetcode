import java.util.ArrayList;
import java.util.List;

public class SubSets_78 {

    public List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums){
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path);
        return ans;
    }

    public void backtracking(int[] nums, int level, List<Integer> path){
        ans.add(new ArrayList<>(path));
        for(int i = level; i < nums.length; ++i){
            path.add(nums[i]);
            backtracking(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
