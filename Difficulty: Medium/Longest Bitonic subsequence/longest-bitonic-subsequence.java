
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        //   int n = nums.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        // Step 1: Compute LIS ending at each index
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        // Step 3: Find max bitonic length
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (inc[i] > 1 && dec[i] > 1) {
                maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
            }
        }

        return maxLen;
    }
}
