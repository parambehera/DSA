class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        int maxSum = nums[0], curMax = nums[0];
        int minSum = nums[0], curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            total += num;

            // Kadane's for max subarray
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // Kadane's for min subarray
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);
        }

        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}
