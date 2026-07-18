class Solution {

    public int minCut(String s) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // Precompute palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2 || pal[i + 1][j - 1]) {
                        pal[i][j] = true;
                    }
                }
            }
        }

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int idx = n - 1; idx >= 0; idx--) {

            int ans = Integer.MAX_VALUE;

            for (int i = idx; i < n; i++) {

                if (pal[idx][i]) {
                    ans = Math.min(ans, 1 + dp[i + 1]);
                }
            }

            dp[idx] = ans;
        }

        return dp[0]-1;
    }
}