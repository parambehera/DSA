import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // DFS from Pacific (top and left)
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, m - 1, heights[i][m - 1]);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, n - 1, j, heights[n - 1][j]);
        }

        // Collect cells reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    // DFS function
    private void dfs(int[][] heights, boolean[][] visited, int row, int col, int prevHeight) {
        int n = heights.length;
        int m = heights[0].length;

        // Boundary + height condition
        if (row < 0 || col < 0 || row >= n || col >= m || visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;

        // Explore 4 directions
        dfs(heights, visited, row + 1, col, heights[row][col]);
        dfs(heights, visited, row - 1, col, heights[row][col]);
        dfs(heights, visited, row, col + 1, heights[row][col]);
        dfs(heights, visited, row, col - 1, heights[row][col]);
    }
}
