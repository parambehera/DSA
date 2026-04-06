import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // store obstacles in set
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        // directions: North, East, South, West
        int[][] dir = {
            {0,1},   // North
            {1,0},   // East
            {0,-1},  // South
            {-1,0}   // West
        };

        int d = 0; // start North
        int x = 0, y = 0;
        int maxDist = 0;

        for (int cmd : commands) {

            if (cmd == -1) {
                d = (d + 1) % 4; // right turn
            } 
            else if (cmd == -2) {
                d = (d + 3) % 4; // left turn
            } 
            else {
                // move step by step
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if (set.contains(nx + "," + ny)) {
                        break; // obstacle → stop
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}