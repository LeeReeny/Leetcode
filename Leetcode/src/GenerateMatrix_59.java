public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        int cnt = 1;
        int up = 0, down = n-1, left = 0, right = n-1;
        while(true){
            for(int i=left; i <= right; ++i) matrix[up][i] = cnt++;
            if(++up > down) break;
            for(int i = up; i <= down; ++i) matrix[i][right] = cnt++;
            if(--right < left) break;
            for(int i=right; i >= left; --i) matrix[down][i] = cnt++;
            if(--down < up) break;
            for(int i=down; i >= up; --i) matrix[i][left] = cnt++;
            if(++left > right) break;
        }
        return matrix;
    }
}
