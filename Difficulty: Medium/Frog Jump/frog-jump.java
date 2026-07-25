class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int dp[]=  new int [n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        helper(height,n-1,dp);
        return dp[n-1]==-1?0:dp[n-1];
    }
    public int helper(int hight[],int idx,int dp[]){
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int cost1 = helper(hight,idx-1,dp)+Math.abs(hight[idx]-hight[idx-1]);
        int cost2 = Integer.MAX_VALUE;
        if(idx>1){
             cost2 = helper(hight,idx-2,dp)+Math.abs(hight[idx]-hight[idx-2]);
        }
        return dp[idx] = Math.min(cost1,cost2);
    }
}