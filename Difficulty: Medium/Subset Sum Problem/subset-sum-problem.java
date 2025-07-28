class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, answer is true (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If no elements, cannot form any positive sum
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                int ele = arr[i - 1];

                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (ele <= j) {
                    take = dp[i - 1][j - ele];
                }

                dp[i][j] = take || notTake;
            }
        }

        return dp[n][sum];
    }
}
