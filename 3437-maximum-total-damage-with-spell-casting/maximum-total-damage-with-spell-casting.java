import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        // Count frequency and collect unique powers
        for (int i = 0; i < n; i++) {
            map.put(power[i], map.getOrDefault(power[i], 0) + 1);
            set.add(power[i]);
        }

        // Convert set to sorted array
        int newPower[] = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            newPower[idx++] = val;
        }
        Arrays.sort(newPower);

        // Memoization array initialized with -1 (uncomputed)
        long[] dp = new long[newPower.length];
        Arrays.fill(dp, -1);

        return helper(0, newPower, map, dp);
    }

    // Memoized recursive function
    public long helper(int idx, int pow[], HashMap<Integer, Integer> map, long[] dp) {
        if (idx >= pow.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        // Binary search for next valid index (>= pow[idx] + 3)
        int nextIdx = binarySearch(pow, idx + 1, pow.length - 1, pow[idx] + 3);

        // Take current power
        long take = (long) map.get(pow[idx]) * pow[idx] + helper(nextIdx, pow, map, dp);

        // Skip current power
        long notTake = helper(idx + 1, pow, map, dp);

        // Memoize result
        dp[idx] = Math.max(take, notTake);
        return dp[idx];
    }

    // Custom binary search
    public int binarySearch(int pow[], int st, int end, int target) {
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (pow[mid] < target) st = mid + 1;
            else end = mid - 1;
        }
        return st;
    }
}
