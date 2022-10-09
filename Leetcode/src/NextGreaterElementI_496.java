import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> hashmap = new HashMap<>(nums2.length);
        for(int i = nums2.length-1; i>=0; i--){
            // 要找到比当前的nums[i]更大的入栈，所以只要<=nums2[i]全都pop掉
            while(!stack.empty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            int val = stack.empty()? -1 : stack.peek();
            hashmap.put(nums2[i], val);
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int j = 0; j < nums1.length; j++){
            ans[j] = hashmap.get(nums1[j]);
        }
        return ans;
    }
}
