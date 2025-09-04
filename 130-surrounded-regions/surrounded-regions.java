import java.util.*;

class Solution {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    List<int[]> cells = new ArrayList<>();
                    boolean surrounded = helper(i, j, vis, board, cells);
                    if (surrounded) {
                        for (int[] cell : cells) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public boolean helper(int row, int col, boolean vis[][], char board[][], List<int[]> cells) {
        int n = board.length, m = board[0].length;

        if (row < 0 || col < 0 || row >= n || col >= m) {
            return false;   // touches border → not surrounded
        }
        if (board[row][col] == 'X' || vis[row][col]) {
            return true;    // safe to ignore
        }

        vis[row][col] = true;
        cells.add(new int[]{row, col}); // save for later decision

        boolean up = helper(row - 1, col, vis, board, cells);
        boolean down = helper(row + 1, col, vis, board, cells);
        boolean left = helper(row, col - 1, vis, board, cells);
        boolean right = helper(row, col + 1, vis, board, cells);

        return up && down && left && right;
    }
}
