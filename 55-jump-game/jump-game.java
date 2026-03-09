class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = Integer.MIN_VALUE;
        if(n==1)
        return true;
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num==0 && i<n-1){
              if(maxJump <=i){
                return false;
              }
            }
             maxJump = Math.max(maxJump,num+i);
        }
        return true;
    }
}