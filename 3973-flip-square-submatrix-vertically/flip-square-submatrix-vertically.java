class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int srow =x+k;
        for(int i=x;i<x+k;i++){
                  srow --;
                swap(grid,i,y,k,srow);
        }
        return grid;
    }
    public void swap (int grid[][],int row,int col,int k,int srow){
        if(row>srow){
            return;
        }
        for(int j =col;j<col+k;j++){
            int temp = grid[row][j];
            grid[row][j] = grid[srow][j];
            grid[srow][j] = temp;
        }
    }
}