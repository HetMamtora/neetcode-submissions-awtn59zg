class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //Pacific: ROWS & COLUMNS
        //top row
        for(int c = 0; c < col; c++){
            dfs(heights, 0, c, pacific, row, col);
        }
        //left col
        for(int r = 0; r < row; r++){
            dfs(heights, r, 0, pacific, row, col);
        }

        //Atlantic: ROWS & COLUMNS
        //bottom row
        for(int c = 0; c < col; c++){
            dfs(heights, row - 1, c, atlantic, row, col);
        }
        //right col
        for(int r = 0; r < row; r++){
            dfs(heights, r, col - 1, atlantic, row, col);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(pacific[r][c] == true && atlantic[r][c] == true){
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visited, int row, int col){
        visited[r][c] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int d = 0; d < 4; d++){
            int newRow = r + dRow[d];
            int newCol = c + dCol[d];

            if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col &&
            !visited[newRow][newCol] && heights[newRow][newCol] >= heights[r][c]){
                dfs(heights, newRow, newCol, visited, row, col);
            }
        }
    }
}
