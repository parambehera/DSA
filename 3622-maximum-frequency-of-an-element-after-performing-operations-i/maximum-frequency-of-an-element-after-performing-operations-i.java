class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxEl = Integer.MIN_VALUE;
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }
        maxEl += k;

        int[] freq = new int[maxEl + 2]; // +2 to avoid bound issues

        // Step 1: frequency count
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: prefix sum
        for (int i = 1; i <= maxEl; i++) {
            freq[i] += freq[i - 1];
        }

        int result = 0;

        // Step 3: check every target value
        for (int target = 0; target <= maxEl; target++) {
            if(target==0){
                continue;
            }

            int leftNum = Math.max(0, target - k);
            int rightNum = Math.min(maxEl, target + k);

            int totalCount = freq[rightNum] - (leftNum > 0 ? freq[leftNum - 1] : 0);
            int targetCount = freq[target] - (target > 0 ? freq[target - 1] : 0);
            int needConv = totalCount - targetCount;

            int possible = targetCount + Math.min(needConv, numOperations);
            result = Math.max(result, possible);
        }

        return result;
    }
}