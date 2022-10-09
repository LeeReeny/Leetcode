public class PathInMatrix_79 {
    public boolean exist(char[][] board, String word){
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        char[] wordAry = word.toCharArray();

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(backtracking(board, wordAry, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean backtracking(char[][] board, char[] wordAry,int i, int j, int pos){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != wordAry[pos]) return false;
        if(pos == wordAry.length-1) return true;

        board[i][j] = '\0';
        boolean f1 = backtracking(board, wordAry, i+1, j, pos+1);
        boolean f2 = backtracking(board, wordAry, i-1, j, pos+1);
        boolean f3 = backtracking(board, wordAry, i, j+1, pos+1);
        boolean f4 = backtracking(board, wordAry, i, j-1, pos+1);
        board[i][j] = wordAry[pos];

        return f1 || f2 || f3 || f4;
    }
}
