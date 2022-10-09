import java.util.Stack;

public class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue(){
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x){
        input.push(x);
    }

    public int pop(){
        in2out();
        int ans = output.pop();
        return ans;
    }

    public int peek(){
        in2out();
        return output.peek();
    }

    public boolean empty(){
        return input.empty();
    }

    public void in2out(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                int x = input.pop();;
                output.push(x);
            }
        }
    }
}
