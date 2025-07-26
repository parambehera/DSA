class Solution {
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int[][] dp = new int[n][4]; // last can be 0,1,2, or 3 (initially no task done)
        
        // Initialize dp with -1
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        
        return helper(dp, 3, arr, n - 1);
    }

    public int helper(int[][] dp, int last, int[][] arr, int day) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, arr[0][i]);
                }
            }
            return dp[day][last] = max;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = arr[day][i] + helper(dp, i, arr, day - 1);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }
}
