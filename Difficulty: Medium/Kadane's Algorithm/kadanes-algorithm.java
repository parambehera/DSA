class Solution {
    int maxSubarraySum(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE; // Track the best sum found so far

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum); // Update best sum so far

            if (sum < 0) sum = 0; // Reset sum when it goes negative
        }

        return maxSum;
    }
}
