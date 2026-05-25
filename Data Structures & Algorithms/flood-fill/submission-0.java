class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if(color == startColor){
            return image;
        }

        int row = image.length;
        int col = image[0].length;

        dfs(image, sr, sc, startColor, color, row, 0);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int startColor, int color, int row, int col){
        image[sr][sc] = color;
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for(int d = 0; d < 4; d++){
            int newRow = sr + dRow[d];
            int newCol = sc + dCol[d];

            if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && image[newRow][newCol] == startColor){
                dfs(image, newRow, newCol, startColor, color, row, col);
            }
        }
    }
}