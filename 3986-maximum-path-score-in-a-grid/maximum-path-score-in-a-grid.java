class Solution {

    Integer[][][] dp;

    public int maxPathScore(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        dp = new Integer[n][m][k + 1];

        int ans = helper(grid, 0, 0, 0, k);

        return ans < 0 ? -1 : ans;
    }

    public int helper(int[][] grid, int row, int col, int cost, int k) {

        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if(row >= n || col >= m) {
            return Integer.MIN_VALUE;
        }

        // Current cell cost
        int currCost = (grid[row][col] == 0) ? 0 : 1;

        cost += currCost;

        // Cost exceeded
        if(cost > k) {
            return Integer.MIN_VALUE;
        }

        // Destination
        if(row == n - 1 && col == m - 1) {
            return grid[row][col];
        }

        // Memoization
        if(dp[row][col][cost] != null) {
            return dp[row][col][cost];
        }

        int right = helper(grid, row, col + 1, cost, k);

        int down = helper(grid, row + 1, col, cost, k);

        int best = Math.max(right, down);

        if(best == Integer.MIN_VALUE) {
            return dp[row][col][cost] = Integer.MIN_VALUE;
        }

        return dp[row][col][cost] = best + grid[row][col];
    }
}