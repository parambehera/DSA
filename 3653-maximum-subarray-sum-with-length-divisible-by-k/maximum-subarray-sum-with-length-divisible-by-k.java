class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix[] = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long maxSum = Long.MIN_VALUE;
        for (int start = 0; start < k; start++) {
            long currSum = 0;
            int i = start;
            while (i < n && (i + k - 1) < n) {
                int j = i + k - 1;
                long sum = prefix[j] - ((i > 0) ? prefix[i - 1] : 0);
                currSum = Math.max(sum, currSum + sum);
                maxSum = Math.max(currSum, maxSum);
                i = i + k;
                // j = i+k-1;
            }
        }
        return maxSum;
    }
}