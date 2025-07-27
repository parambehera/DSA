// class Solution {
//     public int minPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int dp[][]= new int [n][m];
//          dp[0][0] =grid[0][0]; 
//         for(int i =1;i<n;i++){
//             dp[i][0] = dp[i-1][0]+grid[i][0]; 
//         }
//         for(int j =1;j<m;j++){
//             dp[0][j] = dp[0][j-1]+grid[0][j];
//         }
//         for(int i =1;i<n;i++){
//             for(int j =1;j<m;j++){
//                 int top = dp[i-1][j]+grid[i][j];
//                 int left = dp[i][j-1] +grid[i][j];
//                 dp[i][j] = Math.min(top,left);
//             }
//         }
//         return dp[n-1][m-1];
//     }
// }

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(grid, dp, n - 1, m - 1);
    }

    public int helper(int[][] grid, int[][] dp, int row, int col) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE; // <-- this is the key fix
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = helper(grid, dp, row - 1, col);
        int left = helper(grid, dp, row, col - 1);
        return dp[row][col] = grid[row][col] + Math.min(up, left);
    }
}
