import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_offer38 {
    List<String> list;
    StringBuilder path;
    public String[] permutation(String s){
        if(s.length() <= 1) return new String[]{s};
        list = new ArrayList<>();
        path = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        char[] ary = s.toCharArray();
        Arrays.sort(ary);
        backtraking(list, path, used, 0, ary);
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
    }

    public void backtraking(List<String> list, StringBuilder path, boolean[] used, int level, char[] ary){
        if(ary.length == level){
            list.add(new String(path));
            return;
        }

        for(int i = 0; i < ary.length; ++i){
            if(used[i]) continue;
            if(i > 0 && ary[i] == ary[i-1] && !used[i-1]) continue;
            path.append(ary[i]);
            used[i] = true;
            backtraking(list, path, used, level+1, ary);
            used[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}
