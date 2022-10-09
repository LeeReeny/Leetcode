import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures){
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = len-1; i >= 0; i--){
            while(!stack.empty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
