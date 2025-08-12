class Solution {

    int mod = 1_000_000_007;
    Integer[][] dp; // dp[i][sum] to store results

    public int numberOfWays(int n, int x) {
        dp = new Integer[n + 2][n + 1]; // +2 because i can go to n+1
        return f(1, x, n, 0);
    }

    int f(int i, int x, int n, int sum) {
        if (sum == n) return 1;
        if (sum > n || i > n) return 0;

        if (dp[i][sum] != null) return dp[i][sum];

        int power = (int) Math.pow(i, x);
        if (power > n) return dp[i][sum] = 0; // No need to continue if power too big

        int take = f(i + 1, x, n, sum + power) % mod;
        int notTake = f(i + 1, x, n, sum) % mod;

        return dp[i][sum] = (take + notTake) % mod;
    }
}
