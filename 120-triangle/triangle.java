class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        ArrayList<Integer>[] dp = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
        }

        dp[0].add(triangle.get(0).get(0)); // base case

        for (int i = 1; i < n; i++) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                int val = currRow.get(j);

                int fromLeft = (j - 1 >= 0) ? dp[i - 1].get(j - 1) : Integer.MAX_VALUE;
                int fromRight = (j < dp[i - 1].size()) ? dp[i - 1].get(j) : Integer.MAX_VALUE;

                dp[i].add(val + Math.min(fromLeft, fromRight));
            }
        }

        int res = Integer.MAX_VALUE;
        for (int x : dp[n - 1]) {
            res = Math.min(res, x);
        }

        return res;
    }
}
