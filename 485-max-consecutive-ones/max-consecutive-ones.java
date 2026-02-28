class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int maxCnt=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                cnt++;
            }
            else{
                maxCnt= Math.max(cnt,maxCnt);
                cnt=0;
            }
        }
        return Math.max(cnt,maxCnt);
    }
}