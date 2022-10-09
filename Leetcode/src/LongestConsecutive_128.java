import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutive_128 {
    public int longestConsecutive(int[] nums){
        HashSet<Integer> num_set = new HashSet<>();
        for(int num : nums){
            num_set.add(num);
        }
        int longest = 0;
        for(int num : nums){
            if(!num_set.contains(num-1)){
                int cur_len = 1;
                int cur_num = num;
                while(num_set.contains(cur_num + 1)){
                    cur_num++;
                    cur_len++;
                }
                longest = Math.max(longest, cur_len);
            }
        }
        return longest;
    }

    // find and union set
    public int longestConsecutive_1(int[] nums){
        int ans = 0;
        int n = nums.length;;
        if(n==0) return 0;

        int[] parent = new int[n];
        Map<Integer, Integer> num_idx = new HashMap<>();
        for(int i=0; i<n; i++) {
            num_idx.put(nums[i], i);
            parent[i] = i;
        }

        for(int i=0; i < n; i++){
            if(num_idx.containsKey(nums[i]+1)){
                int idx = num_idx.get(nums[i]+1);
                union(parent, i, idx);
            }
        }
        for(int i=0; i<n;i++){
            ans = Math.max(ans, nums[find(parent, i)]-nums[i]);
        }
        return ans;
    }

    public int find(int[] parent, int index){
        while(parent[index] != index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public void union(int[] parent, int idx1, int idx2){
        if(find(parent, idx1) == find(parent, idx2)) return;
        parent[find(parent, idx1)] = find(parent, idx2);
    }
}
