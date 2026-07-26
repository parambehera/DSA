class Solution {
    public int rob(int[] nums) {
        int dp[][] = new int[nums.length][2];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(nums, false, dp, 0);
    }

    public int helper(int nums[], boolean prev, int dp[][], int idx) {
        if (idx == nums.length)
            return 0;

        int p = prev ? 1 : 0;

        if (dp[idx][p] != -1)
            return dp[idx][p];

        int rob = Integer.MIN_VALUE;

        if (!prev)
            rob = nums[idx] + helper(nums, true, dp, idx + 1);

        int skip = helper(nums, false, dp, idx + 1);

        return dp[idx][p] = Math.max(rob, skip);
    }
}