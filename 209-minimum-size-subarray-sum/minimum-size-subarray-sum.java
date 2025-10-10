class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left=0;
        int sum =0;
        int len =Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(left<=i && sum>=target){
                len = Math.min(len,i-left+1);
                if(sum-nums[left]<target){
                    break;
                }
                sum-=nums[left];
                left++;
            }
        }
        return len ==Integer.MAX_VALUE?0:len;
    }
}