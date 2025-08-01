class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return longestSub(0, n - 1, s, dp);
    }

    public int longestSub(int i, int j, String s, Integer[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j ) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + longestSub(i + 1, j - 1, s, dp);
        } else {
            dp[i][j] = Math.max(longestSub(i + 1, j, s, dp), longestSub(i, j - 1, s, dp));
        }

        return dp[i][j];
    }
}
