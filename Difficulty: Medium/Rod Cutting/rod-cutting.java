class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n + 1][n + 1];

        // dp[i][j] = max price by using first i lengths to make rod of length j

        for (int i = 1; i <= n; i++) {
            int rodLength = i; // the current piece length we're considering
            for (int j = 1; j <= n; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (rodLength <= j) {
                    take = price[i - 1] + dp[i][j - rodLength];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }

        return dp[n][n]; // max price for full rod length
    }
}
