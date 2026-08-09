class Solution {
    int[][] memo;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(piles, 0, n - 1) > 0;
    }

    int dp(int[] piles, int i, int j) {
        if (i == j)
            return piles[i];

        if (memo[i][j] != -1)
            return memo[i][j];

        int left = piles[i] - dp(piles, i + 1, j);
        int right = piles[j] - dp(piles, i, j - 1);

        return memo[i][j] = Math.max(left, right);
    }
}