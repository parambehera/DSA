import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c = rotten[1];

                for (int[] dir : directions) {
                    int nRow = r + dir[0];
                    int nCol = c + dir[1];

                    if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col && grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        fresh--;
                        queue.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
