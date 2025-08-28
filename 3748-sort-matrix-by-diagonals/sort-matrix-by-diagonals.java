import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // bottom-left including main diagonal
        for (int srow = n - 1; srow >= 0; srow--) {
            sortDiagonal(grid, srow, 0, false); // descending
        }

        // top-right excluding main diagonal
        for (int scol = 1; scol < n; scol++) {
            sortDiagonal(grid, 0, scol, true); // ascending
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> list = new ArrayList<>();
        int r = row, c = col;

        // collect elements
        while (r < n && c < n) {
            list.add(grid[r][c]);
            r++;
            c++;
        }

        // sort
        if (ascending) {
            Collections.sort(list);
        } else {
            list.sort(Collections.reverseOrder());
        }

        // put back
        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = list.get(idx++);
            r++;
            c++;
        }
    }
}
