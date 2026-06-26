class Solution {
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        //top row
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i, row, col);
            }
        }
        //bottom row
        for(int i = 0; i < col; i++){
            if(board[0][i - 1] == '0'){
                dfs(board, 0, i - 1, row, col);
            }
        }

        //left column
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, row, col);
            }
        }
        //right column
        for(int i = 0; i < row; i++){
            if(board[i - 1] == 'O'){
                dfs(board, i - 1, 0, row, col);
            }
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == 'T'){
                    board[r][c] == 'O';
                }
                if(board[r][c] == 'O'){
                    board[r][c] == 'X';
                }
            }
        }
        
    }

    public void dfs(char[][] board, int r, int c, int row, int col){
        board[r][c] = 'T';

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int d = 0; d < 4; d++){

            int newRow = r + dRow[d];
            int newCol = c + dCol[d];

            if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && board[newRow][newCol] == 'O'){
                dfs(board, newRow, newCol, row, col);
            }
        }
    }
}
