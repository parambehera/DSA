class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n][m];

        // Initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(n - 1, m - 1, text1, text2);
    }

    public int helper(int idx1, int idx2, String text1, String text2) {
        if (idx1 < 0 || idx2 < 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + helper(idx1 - 1, idx2 - 1, text1, text2);
        } else {
            return dp[idx1][idx2] = Math.max(
                helper(idx1 - 1, idx2, text1, text2),
                helper(idx1, idx2 - 1, text1, text2)
            );
        }
    }
}
