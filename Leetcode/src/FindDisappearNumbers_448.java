import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDisappearNumbers_448 {
    public List<Integer> findDisappearNumbers(int[] nums){
        Map<Integer,Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            if(mp.containsKey(num)){
                int val = mp.get(num);
                mp.put(num, val++);
            }
            else mp.put(num, 1);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!mp.containsKey(i)) ans.add(i);
        }
        return ans;
    }

    public List<Integer> findDisappearNumbers_1(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            int pos = Math.abs(num) - 1;
            if(nums[pos] > 0) nums[pos] = -nums[pos];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) ans.add(i+1);
        }
        return ans;
    }



}
