class Solution {
    public int minScoreTriangulation(int[] values) {
        int dp[][]=new int[values.length][values.length];
       
        for(int  i =0;i<values.length;i++){
            Arrays.fill(dp[i],-1);
        }
         return helper(values,0,values.length-1,dp);
    }
    public int helper(int []values,int i,int j,int dp[][]){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k =i+1;k<j;k++){
         ans = Math.min(ans,values[i]*values[j]*values[k]+helper(values,i,k,dp)+helper(values,k,j,dp));
        }
        return dp[i][j]= ans;
    }
}