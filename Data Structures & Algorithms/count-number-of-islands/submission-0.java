class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c, int row, int col) {
        grid[r][c] = '0';

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int d = 0; d < 4; d++){
            int newRow = r + dRow[d];
            int newCol = c + dCol[d];

            if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == '1'){
                dfs(grid, newRow, newCol, row, col);
            }
        }
    }
}
