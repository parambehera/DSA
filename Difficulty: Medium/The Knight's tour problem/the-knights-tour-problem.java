import java.util.*;

class Solution {
    int dix[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int diy[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int arr[][] = new int[n][n];

        // Initialize the board with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        // Start from top-left corner
        arr[0][0] = 0;

        boolean found = knight(0, 0, arr, 1, n);

        // If no solution exists, return [[-1]] as per GFG
        if (!found) {
            ArrayList<ArrayList<Integer>> noSol = new ArrayList<>();
            ArrayList<Integer> row = new ArrayList<>();
            row.add(-1);
            noSol.add(row);
            return noSol;
        }

        // Convert array to ArrayList<ArrayList<Integer>> to return
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(arr[i][j]);
            }
            res.add(list);
        }

        return res;
    }

    private boolean knight(int row, int col, int arr[][], int move, int n) {
        // Base case: all cells visited
        if (move == n * n) return true;

        // Try all 8 knight moves
        for (int i = 0; i < 8; i++) {
            int newRow = row + dix[i];
            int newCol = col + diy[i];

            if (isSafe(newRow, newCol, arr, n)) {
                arr[newRow][newCol] = move;

                // If the path works, stop immediately
                if (knight(newRow, newCol, arr, move + 1, n)) return true;

                // Backtrack if path fails
                arr[newRow][newCol] = -1;
            }
        }

        return false; // no valid moves from here
    }

    private boolean isSafe(int row, int col, int arr[][], int n) {
        return row >= 0 && col >= 0 && row < n && col < n && arr[row][col] == -1;
    }
}
