

// class Solution {
//     public int minCost(int n, int[] cuts) {
//         List<Integer> list = new ArrayList<>();
//         for (int cut : cuts) {
//             list.add(cut);
//         }
//         list.add(0);
//         list.add(n);
//         Collections.sort(list);

//         int m = list.size();
//         int[][] dp = new int[m][m];

//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         return helper(1, m - 2, list, dp);
//     }

//     public int helper(int i, int j, List<Integer> list, int[][] dp) {
//         if (i > j) return 0;

//         if (dp[i][j] != -1) return dp[i][j];
//         int minCost = Integer.MAX_VALUE;
//         for (int idx = i; idx <= j; idx++) {
//             int cost = list.get(j + 1) - list.get(i - 1)
//                      + helper(i, idx - 1, list, dp)
//                      + helper(idx + 1, j, list, dp);
//             minCost = Math.min(minCost, cost);
//         }

//         dp[i][j] = minCost;
//         return minCost;
//     }
// }

class Solution {
      public int minCost(int n, int[] cuts) {
        int c = cuts.length;

        // Step 1: Prepare the cuts array with 0 and n
        List<Integer> cutList = new ArrayList<>();
        for (int cut : cuts) {
            cutList.add(cut);
        }
        cutList.add(0);
        cutList.add(n);
        Collections.sort(cutList);

        // Convert to array for easier indexing
        int[] newCuts = new int[c + 2];
        for (int i = 0; i < c + 2; i++) {
            newCuts[i] = cutList.get(i);
        }

        // Step 2: Create DP table
        int[][] dp = new int[c + 2][c + 2];

        // Step 3: Bottom-up DP
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int minCost = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int cost = newCuts[j + 1] - newCuts[i - 1]
                             + dp[i][ind - 1]
                             + dp[ind + 1][j];

                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }

        // Step 4: Result is stored in dp[1][c]
        return dp[1][c];
    }
}