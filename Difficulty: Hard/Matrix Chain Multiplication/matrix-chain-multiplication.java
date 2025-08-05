class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here  int n = arr.length;
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Initialize DP array with -1 (indicating uncomputed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(arr, 1, n - 1, dp);
        
    }
     private  static int solve(int[] arr, int i, int j, int[][] dp) {
        // Base case: only one matrix, no multiplication needed
        if (i >= j) return 0;

        // If already computed
        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        // Try all possible splits
        for (int k = i; k < j; k++) {
            int cost1 = solve(arr, i, k, dp);
            int cost2 = solve(arr, k + 1, j, dp);
            int costToMultiply = arr[i - 1] * arr[k] * arr[j];

            int totalCost = cost1 + cost2 + costToMultiply;
            minCost = Math.min(minCost, totalCost);
        }

        dp[i][j] = minCost;
        return dp[i][j];
    }
}