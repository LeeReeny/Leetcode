public class SearchMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if(target > matrix[m-1][n-1] || target < matrix[0][0]) return false;
        int i = 0, j = n-1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
