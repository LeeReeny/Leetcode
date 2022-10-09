import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets_20 {
    public boolean isValid(String s){
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[',']');
        brackets.put('{','}');
        Stack<Character> stk = new Stack<>();
        char string[] = s.toCharArray();
        for(int i = 0; i < s.length();i++) {
            if(!stk.isEmpty()){
                char tmp = stk.peek();
                if(brackets.containsKey(tmp)){
                    if(brackets.get(tmp) == string[i]) stk.pop();
                    else stk.push(string[i]);
                }
                else stk.push(string[i]);
            }
            else stk.push(string[i]);
        }
        return stk.isEmpty();
    }

    public boolean isValid_2(String s){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stk.push(s.charAt(i));
            }
            else{
                if(stk.isEmpty()) return false;
                char tmp = stk.peek();
                if(tmp=='(' & s.charAt(i)==')' ||
                        tmp=='[' & s.charAt(i)==']' ||
                        tmp=='{' & s.charAt(i)=='}') stk.pop();
                else return false;
            }
        }
        return stk.isEmpty();
    }

}
