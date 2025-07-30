class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Check if target is valid
        if ((sum + target) % 2 != 0 || target > sum || target < -sum) return 0;
        int subsetSum = (sum + target) / 2;
        return countSubsets(nums, subsetSum);
    }

    public int countSubsets(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // 1 way to make sum 0 (pick nothing)
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (nums[i - 1] <= j) {
                    take = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = take + notTake;
            }
        }

        return dp[n][target];
    }
}
