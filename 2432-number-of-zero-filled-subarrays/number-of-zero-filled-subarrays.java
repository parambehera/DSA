class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int n = nums.length;
        int right = 0;
        int len = 0;

        while (right < n) {
            if (nums[right] == 0) {
                len++;
                right++;
            } else {
                count += (long)len * (len + 1) / 2;
                len = 0;
                right++;
            }
        }

        if (len > 0) {
            count += (long)len * (len + 1) / 2;
        }

        return count;
    }
}
