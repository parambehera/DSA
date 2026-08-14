class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;

        if (n < d) return -1;

        int[][] dp = new int[n][d + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(jobDifficulty, 0, d, dp);
    }

    private int helper(int[] jobs, int idx, int d, int[][] dp) {

        // Last day: all remaining jobs must go here
        if (d == 1) {
            int max = 0;

            for (int i = idx; i < jobs.length; i++) {
                max = Math.max(max, jobs[i]);
            }

            return max;
        }

        if (dp[idx][d] != -1) {
            return dp[idx][d];
        }

        int max = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = idx; i <= jobs.length - d; i++) {

            max = Math.max(max, jobs[i]);

            int remaining = helper(jobs, i + 1, d - 1, dp);

            ans = Math.min(ans, max + remaining);
        }

        return dp[idx][d] = ans;
    }
}