class Solution {
    public int jump(int[] nums) {
       int n = nums.length;
        int dp[]= new int [n];
        dp[0] =0;
        for(int i=1;i<n;i++){
            int minJump = Integer.MAX_VALUE;
            for(int j=i-1;j>=0;j--){
                if(nums[j]+j>=i){
                    minJump = Math.min(dp[j],minJump);
                }
              
            }
            dp[i] = minJump+1;
        }
        return dp[n-1];
    }
}