import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    // Directions: D, L, R, U
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'D', 'L', 'R', 'U'};

    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];

        if (maze[0][0] == 1) {
            findPath(maze, 0, 0, "", visited);
        }

        Collections.sort(list); // optional if you want lexicographic order
        return list;
    }

    private void findPath(int[][] maze, int row, int col, String path, boolean[][] visited) {
        int n = maze.length;

        if (row == n - 1 && col == n - 1) {
            list.add(path);
            return;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            char move = dir[i];

            if (isSafe(maze, newRow, newCol, visited)) {
                findPath(maze, newRow, newCol, path + move, visited);
            }
        }

        visited[row][col] = false; // backtrack
    }

    private boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
        int n = maze.length;
        return row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col];
    }
}
