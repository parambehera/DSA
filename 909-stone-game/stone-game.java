class Solution {
    public boolean stoneGame(int[] piles) {
        int n =piles.length;
        int dp[][]= new int [n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=piles[i];
        }
        int alice = helper(piles,dp,0,n-1);
        return alice > (sum-alice);

    }
    public int helper(int piles[],int dp[][],int i,int j ){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int takei = piles[i]+Math.min(helper(piles,dp,i+2,j),helper(piles,dp,i+1,j-1));
        int takej = piles[j]+Math.min(helper(piles,dp,i,j-2),helper(piles,dp,i+1,j-1));

        return dp[i][j] = Math.max(takei,takej);
    }
}