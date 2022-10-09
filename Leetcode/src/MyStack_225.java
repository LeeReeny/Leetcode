import java.util.LinkedList;
import java.util.Queue;

public class MyStack_225 {

    class MyStack{

        Queue<Integer> input;
        Queue<Integer> output;

        public MyStack(){
            input = new LinkedList<>();
            output = new LinkedList<>();
        }

        public void push(int x){
            input.add(x);
            while(!output.isEmpty()){
                input.add(output.poll());
            }
            Queue<Integer> tmp = input;
            input = output;
            output = tmp;
        }

        public int pop(){
            return output.poll();
        }

        public int top(){
            return output.peek();
        }

        public boolean empty(){
            return output.isEmpty();
        }
    }
}
