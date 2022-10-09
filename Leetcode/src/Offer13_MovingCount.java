import java.util.LinkedList;
import java.util.List;

public class Offer13_MovingCount {
    public int cnt;
    public int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, m, n, k, visited);
        return cnt;
    }

    public void dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        if(i/10 + i%10 + j/10 + j%10 > k) return;
        ++cnt;
        visited[i][j] = true;
        dfs(i+1, j, m, n, k, visited);
        dfs(i-1, j, m, n, k, visited);
        dfs(i, j+1, m, n, k, visited);
        dfs(i, j-1, m, n, k, visited);
        visited[i][j] = false;
    }

    public int movingCnt_bfs(int m, int n, int k){
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if(k == 0) return 1;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(i/10 + i%10 + j/10 + j%10 > k) matrix[i][j] = -1;
            }
        }

        List<int[]> list = new LinkedList<>();
        list.add(new int[]{0,0});
        matrix[0][0] = 1;
        while(list.size() > 0){
            int size = list.size();
            while(size-- > 0){
                int[] cur = ((LinkedList<int[]>) list).poll();
                for(int d = 0; d < 4; ++d){
                    int cur_i = cur[0] + directions[d][0];
                    int cur_j = cur[1] + directions[d][1];
                    if(cur_i>=0 && cur_i<m && cur_j>=0 && cur_j<n && matrix[cur_i][cur_j]==0){
                        list.add(new int[]{cur_i, cur_j});
                        matrix[cur_i][cur_j] = 1;
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 1) ++ans;
            }
        }
        return ans;
    }
}
