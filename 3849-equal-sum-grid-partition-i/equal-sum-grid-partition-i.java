class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;

        // total sum
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        if (total % 2 != 0) return false;

        long target = total / 2;

        // 🔹 Horizontal cut
        long rowSum = 0;
        for (int i = 0; i < n - 1; i++) {  // ensure non-empty bottom
            for (int j = 0; j < m; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == target) return true;
        }

        // 🔹 Vertical cut
        long colSum = 0;
        for (int j = 0; j < m - 1; j++) {  // ensure non-empty right
            for (int i = 0; i < n; i++) {
                colSum += grid[i][j];
            }
            if (colSum == target) return true;
        }

        return false;
    }
}