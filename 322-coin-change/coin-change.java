class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[idx][amount] = minimum coins to make amount using coins[0..idx]
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);  // -1 means not calculated yet
        }

        int ans = helper(n - 1, coins, amount, dp);
        return (ans >= (int)1e9) ? -1 : ans;
    }

    public int helper(int idx, int[] coins, int amount, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int)1e9;
            }
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int notTake = helper(idx - 1, coins, amount, dp);
        int take = (coins[idx] <= amount)
            ? 1 + helper(idx, coins, amount - coins[idx], dp)
            : (int)1e9;

        dp[idx][amount] = Math.min(take, notTake);
        return dp[idx][amount];
    }
}
