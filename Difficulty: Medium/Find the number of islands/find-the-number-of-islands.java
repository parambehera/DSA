class Solution {

    // 8 directions: top, top-right, right, bottom-right, bottom, bottom-left, left, top-left
    int[] nx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] ny = {0, 1, 1, 1, 0, -1, -1, -1};

    public int countIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 'L') {
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col, boolean[][] vis) {
        // Boundary and validity check
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] == 'W') {
            return;
        }

        vis[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int nrx = row + nx[i];
            int nry = col + ny[i];
            dfs(grid, nrx, nry, vis);
        }
    }
}
