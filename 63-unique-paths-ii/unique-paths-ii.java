// class Solution {
//     int[] dx = {0, 1}; // right and down
//     int[] dy = {1, 0};
//     int[][] obstacleGrid; // make it accessible to helper

//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         this.obstacleGrid = obstacleGrid;

//         // If starting cell has obstacle, return 0
//         if (obstacleGrid[0][0] == 1) return 0;

//         int[][] dp = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return helper(dp, 0, 0, m, n);
//     }

//     public int helper(int[][] dp, int row, int col, int m, int n) {
//         // If out of bounds or hitting an obstacle
//         if (row >= m || col >= n || obstacleGrid[row][col] == 1) return 0;

//         // Reached bottom-right
//         if (row == m - 1 && col == n - 1) return 1;

//         if (dp[row][col] != -1) return dp[row][col];

//         int count = 0;

//         for (int i = 0; i < 2; i++) {
//             int rx = row + dx[i];
//             int cy = col + dy[i];

//             count += helper(dp, rx, cy, m, n);
//         }

//         return dp[row][col] = count;
//     }
// }

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        // If starting cell has obstacle, return 0
        if (obstacleGrid[0][0] == 1) return 0;

        dp[0][0] = 1;

        // First column
        for (int i = 1; i < n; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        // First row
        for (int j = 1; j < m; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }

        // Fill the rest
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
