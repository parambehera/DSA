class Solution {
    Integer[][][] dp;  // memo
    final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n][k];
        return cnt(grid, k, 0, 0, 0);
    }

    public int cnt(int[][] grid, int k, int row, int col, int sum) {

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        int rem = sum % k;

        // memoized result
        if (dp[row][col][rem] != null) {
            return dp[row][col][rem];
        }

        // last cell
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return dp[row][col][rem] =
                    ((sum + grid[row][col]) % k == 0) ? 1 : 0;
        }

        int right = cnt(grid, k, row, col + 1, sum + grid[row][col]);
        int down  = cnt(grid, k, row + 1, col, sum + grid[row][col]);

        int ans = (right + down) % MOD;

        return dp[row][col][rem] = ans;
    }
}
