class Solution {
    int dx[] = {1, 0, 0, -1};   // D L R U (IMPORTANT for lexicographic order)
    int dy[] = {0, -1, 1, 0};
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> list = new ArrayList<>();
        int n = maze.length;
        
        if (maze[0][0] == 0) return list;
        
        boolean[][] visited = new boolean[n][n];
        StringBuilder sb = new StringBuilder();
        
        helper(maze, list, 0, 0, sb, visited);
        
        Collections.sort(list);   // ⭐ IMPORTANT LINE
        
        return list;
    }
    
    public void helper(int[][] maze, ArrayList<String> list,
                       int row, int col, StringBuilder sb,
                       boolean[][] visited) {
        
        int n = maze.length;
        
        if (row == n - 1 && col == n - 1) {
            list.add(sb.toString());
            return;
        }
        
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            
            if (isSafe(maze, nextRow, nextCol, visited)) {
                
                if (i == 0) sb.append("D");
                else if (i == 1) sb.append("L");
                else if (i == 2) sb.append("R");
                else sb.append("U");
                
                helper(maze, list, nextRow, nextCol, sb, visited);
                
                sb.deleteCharAt(sb.length() - 1); // backtrack
            }
        }
        
        visited[row][col] = false;
    }
    
    public boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
        int n = maze.length;
        
        if (row < 0 || row >= n || col < 0 || col >= n) return false;
        if (maze[row][col] == 0 || visited[row][col]) return false;
        
        return true;
    }
}