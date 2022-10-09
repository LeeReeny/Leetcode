import java.util.*;

public class MinStack_155 {
    class MinStack{
        Stack<Integer> stack;
        Deque<Integer> s = new ArrayDeque<>();
        int min_value;

        public MinStack(){
            min_value = Integer.MAX_VALUE;
            stack = new Stack<Integer>();
        }

        public void push(int val){
            if(val<=min_value){
                stack.push(min_value);
                min_value = val;
            }
            stack.push(val);
        }

        public void pop(){
            if(stack.pop() == min_value){
                min_value = stack.pop();
            }
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return min_value;
        }
    }
}
