class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List <List <Integer>> ans = new ArrayList <>();
        int n = grid[0].length;
        int m = grid.length;
        int res [][]= new int [m][n];
        while(k!=0){
            for(int i=0;i<m;i++){
                for(int j=0;j<n-1;j++){
                    res[i][j+1] = grid[i][j];
                }
            }
            for(int i=0;i<m-1;i++){
                res[i+1][0] = grid[i][n-1];
            }
            res[0][0] = grid[m-1][n-1];
            k--;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j] = res[i][j];
                }
            }
        }
        for(int i=0;i<m;i++){
            List <Integer> list = new ArrayList<>();
            for(int  j=0;j<n;j++){
                list.add(grid[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
}