import java.util.ArrayList;
import java.util.List;

public class PrintNumber_offer17 {
    private List<String> ans;
    public List<String> printNumber(int n){
        ans = new ArrayList<>();
        for(int i = 0; i <= n; ++i){
            backtracking(i, new StringBuilder());
        }
        return ans;
    }

    public void backtracking(int n, StringBuilder sb){
        if(n == 0){
            ans.add(sb.toString());
            return;
        }

        for(int i = 0; i <= 9; ++i){
            if(i == 0 && sb.length() == 0) continue;
            sb.append(i);
            backtracking(n-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
