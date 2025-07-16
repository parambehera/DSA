//
// import java.util.*;

// class Solution {

//     int[] nx = {-2, -2, -1, -1, 1, 1, 2, 2};
//     int[] ny = {-1, 1, -2, 2, -2, 2, -1, 1};
//     int pathc = Integer.MAX_VALUE;

//     public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
//         int[][] vis = new int[n + 1][n + 1];
//         pathc = Integer.MAX_VALUE;
//         getPath(knightPos[0], knightPos[1], targetPos[0], targetPos[1], n, 0, vis);
//         return pathc == Integer.MAX_VALUE ? -1 : pathc;
//     }

//     public void getPath(int x, int y, int tx, int ty, int n, int count, int[][] vis) {
//         if (x < 1 || x > n || y < 1 || y > n || vis[x][y] == 1) return;

//         if (x == tx && y == ty) {
//             pathc = Math.min(pathc, count);
//             return;
//         }

//         vis[x][y] = 1;

//         for (int i = 0; i < 8; i++) {
//             int nxPos = x + nx[i];
//             int nyPos = y + ny[i];
//             getPath(nxPos, nyPos, tx, ty, n, count + 1, vis);
//         }

//         vis[x][y] = 0; // backtrack
//     }
// }


import java.util.*;

class Solution {

    // 8 possible directions for the knight
    int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    // Helper class to represent knight's position and steps taken
    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        boolean[][] visited = new boolean[n + 1][n + 1];

        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(knightPos[0], knightPos[1], 0));
        visited[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            Cell current = q.poll();

            // If the knight reaches the target position
            if (current.x == targetPos[0] && current.y == targetPos[1]) {
                return current.dist;
            }

            // Try all 8 possible knight moves
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isSafe(nx, ny, n, visited)) {
                    visited[nx][ny] = true;
                    q.add(new Cell(nx, ny, current.dist + 1));
                }
            }
        }

        return -1; // unreachable
    }

    private boolean isSafe(int x, int y, int n, boolean[][] visited) {
        return x >= 1 && x <= n && y >= 1 && y <= n && !visited[x][y];
    }
}
