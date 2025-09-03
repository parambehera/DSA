class Solution {
    // Direction arrays for 4 neighbors (up, down, left, right)
    int distx[] = {1, -1, 0, 0};
    int disty[] = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean vis[][] = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    cnt(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    public void cnt(char[][] grid, boolean vis[][], int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // boundary + water + visited check
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0' || vis[row][col]) {
            return;
        }

        vis[row][col] = true;

        // explore 4 directions
        for (int i = 0; i < 4; i++) {
            int nxtRow = row + distx[i];
            int nxtCol = col + disty[i];
            cnt(grid, vis, nxtRow, nxtCol);
        }
    }
}
