import java.util.Stack;

public class NextGreaterElementII_503 {
    public int[] nextGreaterElements(int[] nums){
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];
        for(int i = 2*len-1; i>=0; i--){
            while(!stack.empty() && nums[i % len] >= stack.peek()){
                stack.pop();
            }
            ans[i % len] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return ans;
    }
}
