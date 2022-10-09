import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
        while(true){
            for(int i=left; i <= right; ++i) ans.add(matrix[up][i]); //向右
            if(++up > down) break; // 重设上边界，如果大于下边界则遍历完成
            for(int i=up; i <= down; ++i) ans.add(matrix[i][right]); //向下
            if(--right < left) break; // 重设右边界
            for(int i=right; i >= left; --i) ans.add(matrix[down][i]); // 向左
            if(--down < up) break; // 重设下边界
            for(int i=down; i >= up; --i) ans.add(matrix[i][left]); // 向上
            if(++left > right) break; // 重设左边界
        }
        return ans;
    }
}
