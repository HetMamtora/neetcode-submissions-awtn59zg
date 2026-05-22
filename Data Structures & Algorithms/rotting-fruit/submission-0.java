class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int freshOrange = 0;
        int minutes = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r, c});
                }
                if(grid[r][c] == 1){
                    freshOrange++;
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            int freshBefore = freshOrange;
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                int[] dRow = {-1, 1, 0, 0};
                int[] dCol = {0, 0, -1, 1};

                for(int d = 0; d < 4; d++){
                    int newRow = r + dRow[d];
                    int newCol = c + dCol[d];

                    if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        freshOrange--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            if(freshBefore != freshOrange){
                minutes++;
            }
        }

        if(freshOrange != 0){
            return -1;
        } else {
            return minutes;
        }
    }
}
