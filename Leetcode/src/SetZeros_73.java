import java.util.HashSet;
import java.util.Set;

public class SetZeros_73 {
    public void setZeros(int[][] matrix){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int r : rows){
            for(int k = 0; k < n; ++k) matrix[r][k] = 0;
        }
        for(int c : cols){
            for(int k = 0; k < m; ++k) matrix[k][c] = 0;
        }
    }

    public void setZeros_1(int[][] matrix){
        boolean rowFlag = false, colFlag = false;
        int m = matrix.length, n = matrix[0].length;
        for(int j = 0; j < n; ++j){  // 第一行是否有0
            if(matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }
        for(int i = 0; i < m; ++i){  // 第一列是否有0
            if(matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;  // 记录标志位
                }
            }
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){  // 置0
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowFlag){
            for(int j = 0; j < n; ++j) matrix[0][j] = 0;
        }
        if(colFlag){
            for(int i = 0; i < m; ++i) matrix[i][0] = 0;
        }
    }
}
