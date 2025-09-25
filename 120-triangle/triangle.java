class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // memo[row][col] stores min path sum starting at (row, col)
        Integer[][] memo = new Integer[n][n];
        return helper(0, 0, triangle, memo);
    }

    private int helper(int row, int col, List<List<Integer>> triangle, Integer[][] memo) {
        // Base: last row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (memo[row][col] != null) return memo[row][col];

        int down = helper(row + 1, col, triangle, memo);
        int diagonal = helper(row + 1, col + 1, triangle, memo);

        // Current value + min of the two choices
        memo[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);
        return memo[row][col];
    }
}
