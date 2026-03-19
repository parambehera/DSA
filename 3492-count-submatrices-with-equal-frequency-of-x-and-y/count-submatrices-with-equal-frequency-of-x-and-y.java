class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] xGrid = new int[n][m];
        int[][] yGrid = new int[n][m];

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                int x = (grid[i][j] == 'X') ? 1 : 0;
                int y = (grid[i][j] == 'Y') ? 1 : 0;

                xGrid[i][j] = x;
                yGrid[i][j] = y;

                if(i > 0){
                    xGrid[i][j] += xGrid[i-1][j];
                    yGrid[i][j] += yGrid[i-1][j];
                }

                if(j > 0){
                    xGrid[i][j] += xGrid[i][j-1];
                    yGrid[i][j] += yGrid[i][j-1];
                }

                if(i > 0 && j > 0){
                    xGrid[i][j] -= xGrid[i-1][j-1];
                    yGrid[i][j] -= yGrid[i-1][j-1];
                }

                // example condition (depends on problem)
                if(xGrid[i][j] == yGrid[i][j] && xGrid[i][j] > 0){
                    count++;
                }
            }
        }

        return count;
    }
}