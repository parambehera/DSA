class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int hb = Integer.MIN_VALUE;
        int lb = 1;
        for (int i = 0; i < nums.length; i++) {
            hb = Math.max(hb, nums[i]);
        }
        int ans =-1;
        while (lb <= hb) {
            int mid = lb + (hb - lb) / 2;
            if (isPossible(nums, threshold, mid)) {
                ans =mid;
                hb = mid - 1;
            } else {
               lb  = mid + 1;
            }
        }
        return ans;

    }

    public boolean isPossible(int nums[], int threshold, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double) nums[i] / divisor);
        }
        return sum <= threshold;
    }
}