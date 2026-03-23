class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = Integer.MIN_VALUE;
        int n = nums.length;

        int prefixPro = 1;
        int suffixPro = 1;

        for (int i = 0; i < n; i++) {
            prefixPro *= nums[i];
            suffixPro *= nums[n - 1 - i];

            maxPro = Math.max(maxPro, Math.max(prefixPro, suffixPro));

            // reset AFTER using
            if (prefixPro == 0) prefixPro = 1;
            if (suffixPro == 0) suffixPro = 1;
        }

        return maxPro;
    }
}