class Solution {

    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];
        isSubsetSum(arr, sum, dp);

        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n][s1]) {
                int s2 = sum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }
        return minDiff;
    }

    boolean isSubsetSum(int arr[], int sum, boolean[][] dp) {
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

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
