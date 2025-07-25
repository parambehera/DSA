// class Geeks {
//     public long count(int n) {
//         long[] dp = new long[n + 1];
//         for (int i = 0; i <= n; i++) {
//             dp[i] = -1;
//         }
//         return memoC(n, dp);
//     }

//     public long memoC(int n, long[] dp) {
//         if (n < 0) return 0;
//         if (n == 0) return 1;
//         if (dp[n] != -1) return dp[n];
        
//         dp[n] = memoC(n - 3, dp) + memoC(n - 5, dp) + memoC(n - 10, dp);
//         return dp[n];
//     }
// }
class Geeks {
    public long count(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1; // One way to make 0
        
        int[] moves = {3, 5, 10};
        
        for (int move : moves) {
            for (int i = move; i <= n; i++) {
                dp[i] += dp[i - move];
            }
        }
        
        return dp[n];
    }
}
