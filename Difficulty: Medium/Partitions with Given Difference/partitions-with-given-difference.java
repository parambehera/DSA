class Solution {
    public int countPartitions(int[] arr, int d) {
        int sum = 0;
        for (int val : arr) sum += val;

        // Check if (sum + d) is even
        if ((sum + d) % 2 != 0 || sum < d) return 0;

        int target = (sum + d) / 2;
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        return perfectSum(arr, target, dp);
    }

    public int perfectSum(int[] arr, int target, int[][] dp) {
        int n = arr.length;
        int mod = (int)1e9 + 7;

        // Initialize: there's always 1 subset (empty set) with sum = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                // Exclude
                dp[i][sum] = dp[i - 1][sum];

                // Include
                if (arr[i - 1] <= sum) {
                    dp[i][sum] = (dp[i][sum] + dp[i - 1][sum - arr[i - 1]]) % mod;
                }
            }
        }

        return dp[n][target];
    }
}
