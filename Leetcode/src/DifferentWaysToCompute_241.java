import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToCompute_241 {
    public List<Integer> diffWaysToCompute(String expression){
        List<Integer> ways = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            char op = expression.charAt(i);
            if(op == '*' || op == '+' || op == '-'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(int l : left){
                    for(int r : right){
                        switch (op){
                            case ('+'): ways.add(l + r); break;
                            case ('*'): ways.add(l * r); break;
                            case ('-'): ways.add(l - r); break;
                        }
                    }
                }
            }
        }
        if (ways.isEmpty()) ways.add(Integer.valueOf(expression));
        return ways;
    }
}
