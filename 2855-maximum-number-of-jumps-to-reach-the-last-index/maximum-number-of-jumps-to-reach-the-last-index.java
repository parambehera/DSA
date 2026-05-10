class Solution {

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = i + 1; j < n; j++) {

                int diff = nums[j] - nums[i];

                if (diff >= -target && diff <= target) {
                    list.add(j);
                }
            }

            map.put(i, list);
        }

        Integer dp[] = new Integer[n];

        int ans = helper(nums, map, 0, dp);

        return ans < 0 ? -1 : ans;
    }

    public int helper(int nums[],
                      HashMap<Integer, List<Integer>> map,
                      int idx,
                      Integer dp[]) {

        int n = nums.length;

        if (idx == n - 1) {
            return 0;
        }

        // already computed
        if (dp[idx] != null) {
            return dp[idx];
        }

        int max = Integer.MIN_VALUE;

        for (int j : map.get(idx)) {

            int next = helper(nums, map, j, dp);

            if (next == Integer.MIN_VALUE) {
                continue;
            }

            max = Math.max(max, 1 + next);
        }

        return dp[idx] = max;
    }
}