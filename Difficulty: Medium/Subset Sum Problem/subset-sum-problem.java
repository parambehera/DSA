class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n =arr.length;
        boolean dp[][]= new boolean [n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        
        for(int i = n-1;i>=0;i--){
            for(int j = 1;j<=sum;j++){
                boolean take = false;
                if(j>=arr[i]){
                    take = dp[i+1][j-arr[i]];
                }
                boolean notTake = dp[i+1][j];
                dp[i][j] = take || notTake;
            }
        }
        return dp[0][sum];
        
    }
    static Boolean Sum(int arr[],int idx,int sum){
        if(sum==0){
            return true;
        }
        if(idx==arr.length){
            return false;
        }
        
        boolean take = Sum(arr,idx+1,sum-arr[idx]);
        boolean notTake = Sum(arr,idx+1,sum);
        return take || notTake;
    }
}