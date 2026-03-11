class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int INF = (int) 1e9;

        int dp[][] = new int[n + 1][amount + 1];

        for (int j = 0; j <= amount; j++) {
            dp[n][j] = INF;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int idx = n - 1; idx >= 0; idx--) {

            for (int amt = 1; amt <= amount; amt++) {

                int take = INF;

                if (coins[idx] <= amt) {
                    take = 1 + dp[idx][amt - coins[idx]];
                }

                int notTake = dp[idx + 1][amt];

                dp[idx][amt] = Math.min(take, notTake);
            }
        }

        int ans = dp[0][amount];
        return ans >= INF ? -1 : ans;
    }

    public int helper(int idx, int coins[], int amount) {
        int n = coins.length;
        if (amount == 0) {
            return 0;
        }
        if (idx == n) {
            return Integer.MAX_VALUE;
        }

        int take = Integer.MAX_VALUE;
        if (coins[idx] <= amount) {
            int res = helper(idx, coins, amount - coins[idx]);
            if (res != take) {
                take = res + 1;
            }
        }
        int notTake = helper(idx + 1, coins, amount);

        return Math.min(take, notTake);
    }
}