class Solution {
    static int[][] dp;

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        dp = new int[n][sum + 1];  // -1 = unvisited, 0 = false, 1 = true
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, arr, sum);
    }

    static boolean helper(int i, int arr[], int target) {
        if (target == 0) return true;
        if (i == arr.length) return false;

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        // Choice 1: skip this element
        boolean notTake = helper(i + 1, arr, target);

        // Choice 2: take this element (only if <= target)
        boolean take = false;
        if (arr[i] <= target) {
            take = helper(i + 1, arr, target - arr[i]);
        }

        boolean ans = take || notTake;
        dp[i][target] = ans ? 1 : 0;
        return ans;
    }
}
