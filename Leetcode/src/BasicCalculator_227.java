import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator_227 {
    public int calculate(String s){
        char[] ary = s.toCharArray();
        Deque<Integer> stk = new LinkedList<>();
        int ans = 0;
        char op = '+';
        int num = 0;
        for(int i=0; i<ary.length; i++){
            if(Character.isDigit(ary[i])){
                num = num * 10 + ary[i] - '0';
            }
            if(!Character.isDigit(ary[i]) && ary[i] != ' ' || i == ary.length-1){
                switch(op){
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    case '*':
                        stk.push(stk.pop() * num);
                        break;
                    default:
                        stk.push(stk.pop() / num);
                }
                op = ary[i];
                num = 0;
            }
        }
        while(!stk.isEmpty()){
            ans += stk.pop();
        }
        return ans;
    }
}
