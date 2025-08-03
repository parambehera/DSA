import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1]; // last can be -1 (n positions total)
        return helper(nums, 0, -1, dp);
    }

    public int helper(int[] nums, int idx, int lastIdx, Integer[][] dp) {
        if (idx == nums.length) return 0;

        if (dp[idx][lastIdx + 1] != null) return dp[idx][lastIdx + 1];

        int notTake = helper(nums, idx + 1, lastIdx, dp);
        int take = Integer.MIN_VALUE;
        if (lastIdx == -1 || nums[idx] > nums[lastIdx]) {
            take = 1 + helper(nums, idx + 1, idx, dp);
        }

        return dp[idx][lastIdx + 1] = Math.max(take, notTake);
    }
}
