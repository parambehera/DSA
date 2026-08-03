class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        int n = nums.length;
        if(nums.length==1)return true;
        for(int i=0;i<n;i++){
            if(nums[i]==0 && maxJump <= i){
                return false;
            }
            maxJump  = Math.max(nums[i]+i,maxJump);
            if(maxJump==n-1) 
            return true;
        }
        return true;
    
    }
}