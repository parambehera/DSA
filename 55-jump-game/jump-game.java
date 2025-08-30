class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // 0 = not visited, 1 = true, -1 = false
        return helper(nums, 0, dp);
    }

    public boolean helper(int[] nums, int pos, int[] dp) {
        if (pos == nums.length - 1) {
            return true;
        }
        if (dp[pos] != 0) {
            return dp[pos] == 1;
        }

        int maxjump = nums[pos];
        for (int i = 1; i <= maxjump && pos + i < nums.length; i++) {
            if (helper(nums, pos + i, dp)) {
                dp[pos] = 1;
                return true;
            }
        }

        dp[pos] = -1;
        return false;
    }
}
