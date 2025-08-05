import java.util.*;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Create a new array with 1 at both ends
        int[] a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            a[i + 1] = nums[i];
        }

        // Initialize dp table
        int[][] dp = new int[n + 2][n + 2];

        // Bottom-up DP
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;

                int max = Integer.MIN_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int cost = a[i - 1] * a[ind] * a[j + 1] +
                               dp[i][ind - 1] + dp[ind + 1][j];
                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}
