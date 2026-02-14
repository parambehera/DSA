class Solution {

    static Boolean[][] memo;

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        memo = new Boolean[n][sum + 1];

        return helper(arr, 0, sum);
    }

    static boolean helper(int arr[], int i, int target) {

        // If target becomes 0 → subset found
        if (target == 0) return true;

        // If reached end or target negative
        if (i == arr.length || target < 0) return false;

        // If already computed
        if (memo[i][target] != null)
            return memo[i][target];

        // Take element
        boolean take = helper(arr, i + 1, target - arr[i]);

        // Not take element
        boolean notTake = helper(arr, i + 1, target);

        memo[i][target] = take || notTake;

        return memo[i][target];
    }
}
