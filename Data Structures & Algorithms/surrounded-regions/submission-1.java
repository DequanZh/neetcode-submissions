class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for(int r = 0; r < n; r++){
            dfs(board,r,0);
            dfs(board,r,m-1);
        }
        for(int c = 0; c < m; c++){
            dfs(board,0,c);
            dfs(board,n-1,c);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] == 'X' || board[x][y] == 'T'){
            return;
        }
        board[x][y] = 'T';
        for(int[] next : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}){
            dfs(board,x+next[0],y+next[1]);
        }
    }
}
