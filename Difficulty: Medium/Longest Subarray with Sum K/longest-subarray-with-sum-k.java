// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
           Map<Integer, Integer> prefixMap = new HashMap<>(); // prefixSum -> first index
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: whole array from 0 to i has sum k
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // Case 2: subarray from some index+1 to i has sum k
            if (prefixMap.containsKey(prefixSum - k)) {
                int len = i - prefixMap.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store the first occurrence of this prefix sum
            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
