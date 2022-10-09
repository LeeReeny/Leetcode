import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k){
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(!dq.isEmpty() && dq.getFirst() == i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1){
                ans[cnt] = nums[dq.getFirst()];
                cnt++;
            }
        }
        return ans;
    }
}
