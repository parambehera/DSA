class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int startRow = 0;
        int endRow = n - 1;

        int startCol = 0;
        int endCol = m - 1;

        while (startRow < endRow && startCol < endCol) {

            ArrayList<Integer> list = new ArrayList<>();

            // top row
            for (int j = startCol; j <= endCol; j++) {
                list.add(grid[startRow][j]);
            }

            // right column
            for (int i = startRow + 1; i <= endRow; i++) {
                list.add(grid[i][endCol]);
            }

            // bottom row
            for (int j = endCol - 1; j >= startCol; j--) {
                list.add(grid[endRow][j]);
            }

            // left column
            for (int i = endRow - 1; i > startRow; i--) {
                list.add(grid[i][startCol]);
            }

            int size = list.size();

            int kk = k % size;

            ArrayList<Integer> rotated = new ArrayList<>();

            // correct rotation
            for (int i = 0; i < size; i++) {
                rotated.add(list.get((i + kk) % size));
            }

            int idx = 0;

            // fill top row
            for (int j = startCol; j <= endCol; j++) {
                grid[startRow][j] = rotated.get(idx++);
            }

            // fill right column
            for (int i = startRow + 1; i <= endRow; i++) {
                grid[i][endCol] = rotated.get(idx++);
            }

            // fill bottom row
            for (int j = endCol - 1; j >= startCol; j--) {
                grid[endRow][j] = rotated.get(idx++);
            }

            // fill left column
            for (int i = endRow - 1; i > startRow; i--) {
                grid[i][startCol] = rotated.get(idx++);
            }

            startRow++;
            endRow--;

            startCol++;
            endCol--;
        }

        return grid;
    }
}