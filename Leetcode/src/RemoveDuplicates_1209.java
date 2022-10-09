import java.util.Stack;

public class RemoveDuplicates_1209 {
    public String removeDumplicates(String s, int k){
        int len = s.length();
        if(len == 1) return k == 1 ? "" : s;
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < sb.length(); ++i){
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) stk.push(1);
            else{
                int cnt = stk.pop() + 1;
                if(cnt == k) {
                    sb.delete(i-k+1, i+1);
                    i = i - k;
                }
                else stk.push(cnt);
            }
        }
        return sb.toString();
    }
}
