class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m]; // -1 = uncomputed, 0 = false, 1 = true

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;

        return f(n - 1, m - 1, dp, s, p);
    }

    boolean f(int i, int j, int[][] dp, String s, String p) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = f(i - 1, j - 1, dp, s, p);
        } else if (p.charAt(j) == '*') {
            ans = f(i - 1, j, dp, s, p) || f(i, j - 1, dp, s, p);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
