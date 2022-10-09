import sun.awt.geom.AreaOp;

public class SurroundedRegions_130 {
    private static void dfs(char[][] board, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!='O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board, i+1, j, m, n);
        dfs(board, i-1, j, m, n);
        dfs(board, i, j+1, m, n);
        dfs(board, i, j-1, m, n);
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        int m = board.length;
        // if(m==0) return;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            dfs(board, i, 0, m, n);
            dfs(board, i, n-1, m, n);
        }

        for(int j=0; j<n; j++){
            dfs(board, 0, j, m, n);
            dfs(board, m-1, j, m, n);
        }

        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(board[x][y]=='A'){
                    board[x][y] = 'O';
                }
                else if(board[x][y]=='O'){
                    board[x][y] = 'X';
                }
            }
        }
        for(int i=0; i<m; i++){
            System.out.println(board[i]);
        }
    }
}
