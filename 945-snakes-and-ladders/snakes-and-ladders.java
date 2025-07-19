import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1]; // 1-based indexing
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // {square number, move count}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int square = curr[0];
            int moves = curr[1];

            for (int i = 1; i <= 6; i++) {
                int next = square + i;
                if (next > n * n) continue;

                int[] pos = getPosition(next, n);
                int r = pos[0], c = pos[1];

                if (board[r][c] != -1) {
                    next = board[r][c]; // take snake or ladder
                }

                if (next == n * n) {
                    return moves + 1; // reached goal
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1; // unreachable
    }

    // Converts square number (1-based) to (row, col) in boustrophedon layout
    private int[] getPosition(int num, int n) {
        int r = n - 1 - (num - 1) / n;
        int c = (num - 1) % n;
        if ((n - r) % 2 == 0) {
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}
