class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        
        for(int i =0;i<m;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j =0;j<m;j++){
                int leftParent = (j-1<0)?Integer.MAX_VALUE:matrix[i][j]+dp[i-1][j-1];
                int directParent = matrix[i][j]+dp[i-1][j];
                int rightParent = (j+1>=m)?Integer.MAX_VALUE:matrix[i][j]+dp[i-1][j+1];
                dp[i][j] =Math.min(leftParent,Math.min(rightParent,directParent));
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i =0;i<m;i++){
            res = Math.min(res,dp[n-1][i]);
        }
        return res;
    }
}