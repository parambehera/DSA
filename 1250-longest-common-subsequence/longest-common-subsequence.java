// class Solution {
//     int[][] dp;
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         dp = new int[n][m];

//         // Initialize dp with -1
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return helper(n - 1, m - 1, text1, text2);
//     }

//     public int helper(int idx1, int idx2, String text1, String text2) {
//         if (idx1 < 0 || idx2 < 0) return 0;

//         if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

//         if (text1.charAt(idx1) == text2.charAt(idx2)) {
//             return dp[idx1][idx2] = 1 + helper(idx1 - 1, idx2 - 1, text1, text2);
//         } else {
//             return dp[idx1][idx2] = Math.max(
//                 helper(idx1 - 1, idx2, text1, text2),
//                 helper(idx1, idx2 - 1, text1, text2)
//             );
//         }
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        // dp[i][j] = length of LCS of text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match, take diagonal + 1
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Characters don't match, take max from top or left
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m]; // Final LCS length
    }
}
