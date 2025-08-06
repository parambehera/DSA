// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         int n = arr.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         return f(0, arr, k, dp);
//     }
//     public int f(int i, int[] arr, int k, int[] dp) {
//         int n = arr.length;
//         if (i == n) return 0;
//         if (dp[i] != -1) return dp[i];
//         int maxInPartition = Integer.MIN_VALUE;
//         int maxSum = Integer.MIN_VALUE;

//         for (int j = i; j < Math.min(n, i + k); j++) {
//             maxInPartition = Math.max(maxInPartition, arr[j]);
//             int length = j - i + 1;
//             int sum = maxInPartition * length + f(j + 1, arr, k, dp);
//             maxSum = Math.max(maxSum, sum);
//         }

//         return dp[i] = maxSum;
//     }
// }
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
    int n =arr.length;
    int dp[]= new int[n+1];
    for(int i =n-1;i>=0;i--){
        int maxInPartition = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
         for (int j = i; j < Math.min(n, i + k); j++) {
             maxInPartition = Math.max(maxInPartition, arr[j]);
            int length = j - i + 1;
            int sum = maxInPartition * length + dp[j+1];
            maxSum = Math.max(maxSum, sum);
         }
         dp[i] = maxSum;
    }
    return dp[0];
    }
}
