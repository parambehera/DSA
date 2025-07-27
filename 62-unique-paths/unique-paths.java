// class Solution {
//     int[] dx = {0, 1}; // right and down
//     int[] dy = {1, 0};

//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];

//         // Initialize dp with -1 (unvisited)
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return helper(dp, 0, 0, m, n);
//     }

//     public int helper(int[][] dp, int row, int col, int m, int n) {
//         if (row == m - 1 && col == n - 1) {
//             return 1;
//         }

//         if (row >= m || col >= n) return 0;

//         if (dp[row][col] != -1) return dp[row][col];

//         int count = 0;

//         for (int i = 0; i < 2; i++) {
//             int rx = row + dx[i];
//             int cy = col + dy[i];

//             if (rx < m && cy < n) {
//                 count += helper(dp, rx, cy, m, n);
//             }
//         }

//         return dp[row][col] = count;
//     }
// }

class Solution{
     public int uniquePaths(int m, int n) {
        int dp[][]  = new int [n][m];

        for(int i=0;i<dp.length;i++){
          dp[i][0] = 1;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] =1;
        }
        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
               dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
     }
}