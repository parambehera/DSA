class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int rsum[] = new int[n];
        int csum[] = new int[m];

        // row sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];   // ✅ use grid not arr
            }
            rsum[i] = sum;
        }

        // column sums
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += grid[i][j];   // ✅ correct indexing
            }
            csum[j] = sum;
        }

        // find first and last rows that contain a 1
        int top = -1, bottom = -1;
        for (int i = 0; i < n; i++) {
            if (rsum[i] > 0) {
                if (top == -1) top = i;
                bottom = i;
            }
        }

        // find first and last cols that contain a 1
        int left = -1, right = -1;
        for (int j = 0; j < m; j++) {
            if (csum[j] > 0) {
                if (left == -1) left = j;
                right = j;
            }
        }

        if (top == -1) return 0; // no 1's found

        int height = bottom - top + 1;
        int width = right - left + 1;

        return height * width;
    }
}
