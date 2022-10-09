import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddress {
    List<String> ans;
    public List<String> restoreIpAddress(String s){
        ans = new ArrayList<>();
        int len = s.length();
        if(len < 4 || len > 12) return ans;
        Deque<String> path = new ArrayDeque<>();
        backtracking(s, 4, 0, len, path);
        return ans;
    }

    public void backtracking(String s, int residue, int start, int len, Deque<String> path) {
        if (start == len) {
            if (residue == 0) ans.add(String.join(".", path)); // 剩余段数为0，说明已经切割完成
            return;
        }

        for(int i = start; i < start + 3; ++i){
            if(i >= len) break; // 已经超过了字符串的长度
            if(residue * 3 < len - i) continue;  // 剩余段的长度太长，剪枝

            if(validIpSegment(s, start, i)){
                String curSegment = s.substring(start, i + 1);
                path.addLast(curSegment);
                backtracking(s, residue-1, i+1, len, path);
                path.removeLast();
            }
        }
    }

    private boolean validIpSegment(String s, int l, int r){
        int len = r - l + 1;
        if(len > 1 && s.charAt(l) == '0') return false;

        int num = 0;
        while(l <= r){
            num = num * 10 + s.charAt(l) - '0';
            ++l;
        }
        return num >=0 && num <= 255;
    }
}
