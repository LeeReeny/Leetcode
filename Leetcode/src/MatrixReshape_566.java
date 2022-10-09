public class MatrixReshape_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c){
        int m = mat.length;
        int n = mat[0].length;
        if(r*c != m*n) return mat;

        int[][] ans = new int[r][c];
        for(int i=0; i<m*n; i++){  //转化原数组的第i个元素
            ans[i/c][i%c] = mat[i/n][i%n];
        }
        return ans;
    }
}
