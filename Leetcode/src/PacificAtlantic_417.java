import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic_417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(atlantic_dfs(heights, i, j) && pacific_dfs(heights, i, j)){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private boolean atlantic_dfs(int[][] heights, int i, int j){
        boolean flag  = false;
        if(i >= 0 && i < heights.length-1 && j >=0 && j < heights[0].length-1){
            if(heights[i][j] <= heights[i+1][j] || heights[i][j] <= heights[i][j+1]){
                flag = true;
            }
        }
        return flag && (atlantic_dfs(heights, i+1, j) || atlantic_dfs(heights, i, j+1));
    }

    private boolean pacific_dfs(int[][] heights, int i, int j){
        boolean flag = true;
        if(i > 0 && i < heights.length && j > 0 && j < heights[0].length){
            if(heights[i][j] >= heights[i-1][j] || heights[i][j] >= heights[i][j-1]){
                flag = true;
            }
        }
        return flag && (pacific_dfs(heights, i-1, j) || pacific_dfs(heights, i, j-1));
    }


    // 水往高处流
    int[] directions = {-1, 0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic_1(int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] reach_parcific = new boolean[m][n];
        boolean[][] reach_atlantic = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            dfs(heights, reach_parcific, i, 0);
            dfs(heights, reach_atlantic, i, n-1);
        }
        for(int j = 0; j < n; ++j){
            dfs(heights, reach_parcific, 0, j);
            dfs(heights, reach_atlantic, n-1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(reach_atlantic[i][j] && reach_parcific[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, boolean[][] reach, int i, int j){
        if(reach[i][j]) return;
        reach[i][j] = true;
        for(int d = 0; d < 4; ++d){
            int r = i + directions[d];
            int c = j + directions[d + 1];
            if(r >= 0 && r < heights.length && c >=0 && c < heights[0].length && heights[i][j] <= heights[r][c]){
                dfs(heights, reach, r, c);
            }
        }
    }


}
