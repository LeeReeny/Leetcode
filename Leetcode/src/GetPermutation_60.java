import java.util.Arrays;

public class GetPermutation_60 {
    private boolean used[]; //记录数字是否使用过
    private int[] factorial; // 阶乘数组

    public String getPermutation(int n, int k){
        calculateFactorial(n);
        used = new boolean[n+1];
        Arrays.fill(used, false);
        StringBuilder path = new StringBuilder();
        dfs(0, path, n, k);
        return path.toString();
    }

    private void dfs(int idx, StringBuilder path, int n, int k){
        if(idx == n) return;
        // 计算还未确定的数字的全排列的个数
        int cnt = factorial[n-1-idx];
        for(int i=1; i <= n; ++i){
            if(used[i]) continue;
            if(cnt < k){
                k -= cnt;
                continue;
            }
            path.append((i));
            used[i] = true;
            dfs(idx+1, path, n, k);
            return;
        }
    }

    private void calculateFactorial(int n){
        factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1; i<=n; ++i){
            factorial[i] = factorial[i-1] * i;
        }
    }
}
