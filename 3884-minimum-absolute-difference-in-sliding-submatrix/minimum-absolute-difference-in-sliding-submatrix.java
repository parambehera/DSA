class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans [][]= new int[m-k+1][n-k+1];
        for(int i=0;i<ans.length;i++){
            for(int j =0;j<ans[0].length;j++){
              ans[i][j] = findAbsDiff(grid,k,i,j);
            }
        }
        return ans;
    }
    public int findAbsDiff(int grid[][], int k, int row, int col){
    int idx = 0;
    int sub[] = new int[k * k];

    for(int i = row; i < row + k; i++){
        for(int j = col; j < col + k; j++){
            sub[idx++] = grid[i][j];
        }
    }

    Arrays.sort(sub);

    int minDiff = Integer.MAX_VALUE;

    for(int i = 0; i < sub.length - 1; i++){
        if(sub[i] == sub[i+1]) continue; // ✅ skip duplicates
        int diff = sub[i+1] - sub[i];
        minDiff = Math.min(minDiff, diff);
    }

    // ✅ if all elements same → minDiff never updated
    return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
}
}