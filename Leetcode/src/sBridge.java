import java.util.LinkedList;
import java.util.Queue;


public class sBridge {
    private static void dfs(Queue<int[]> points, int grid[][], int i, int j, int m, int n) {
        if(i<0 || i==m || j<0 || j==n || grid[i][j]==2) return;
        if(grid[i][j] == 0) {
            points.add(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        dfs(points, grid, i+1, j, m, n);
        dfs(points, grid, i-1, j, m, n);
        dfs(points, grid, i, j+1, m, n);
        dfs(points, grid, i, j-1, m, n);
    }

    private static int findBridge(int grid[][]) {
        int[] directions = {-1, 0, 1, 0, -1};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> points = new LinkedList<>();
        boolean flipped = false;
        for(int i=0; i<m; i++) {
            if(flipped) break;
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    dfs(points, grid, i, j, m, n);
                    flipped = true;
                    break;
                }
            }
        }
        int x, y, level = 0;
        while(!points.isEmpty()) {
            level += 1;
            int n_points = points.size();
            while(n_points>0) {
                n_points -= 1;
                int[] tmp = points.poll();
                int r = tmp[0];
                int c = tmp[1];
                for(int k=0; k<4;k++) {
                    x = r + directions[k];
                    y = c + directions[k+1];
                    if(x>=0 && x<m && y>=0 && y<n) {
                        if(grid[x][y]==2) continue;
                        if(grid[x][y]==1) return level;
                        points.add(new int[] {x,y});
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int grid[][] = {{0,1}, {1,0}};
        int ans = findBridge(grid);
        System.out.println(ans);
    }

}

