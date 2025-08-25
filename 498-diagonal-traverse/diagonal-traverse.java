class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int n = mat.length;
        int m = mat[0].length;
        int row = 0, col = 0;
        boolean up = true;
        ArrayList<Integer> list = new ArrayList<>();

        while (row < n && col < m) {
            if (up) {
                // Traverse up-right
                while (row > 0 && col < m - 1) {
                    list.add(mat[row][col]);
                    row--;
                    col++;
                }
                list.add(mat[row][col]);
                if (col == m - 1) row++;
                else col++;
                up = false;
            } else {
                // Traverse down-left
                while (col > 0 && row < n - 1) {
                    list.add(mat[row][col]);
                    row++;
                    col--;
                }
                list.add(mat[row][col]);
                if (row == n - 1) col++;
                else row++;
                up = true;
            }
        }

        // Convert list to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
