class Solution {
    public int perfectSum(int[] arr, int target) {
        int n = arr.length;
        // int mod = (int)1e9 + 7;

        int[][] dp = new int[n + 1][target + 1];

        // Initialize: There's always 1 subset (empty set) with sum = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                // Exclude current
                dp[i][sum] = dp[i - 1][sum];

                // Include current, if possible
                if (arr[i - 1] <= sum) {
                    dp[i][sum] = (dp[i][sum] + dp[i - 1][sum - arr[i - 1]]);
                }
            }
        }

        return dp[n][target];
    }
}
