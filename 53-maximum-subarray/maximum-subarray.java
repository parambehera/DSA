class Solution {
    public int maxSubArray(int[] nums) {
        int gmax = Integer.MIN_VALUE;
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            gmax = Math.max(sum,gmax);
            if(sum<0){
                sum=0;
            }
        }
        return gmax;
    }
}