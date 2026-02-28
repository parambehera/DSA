class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        int n = nums.length;
        for(int i=1;i<n;i++){
          if(nums[i]!=nums[i-1]){
            idx++;
            nums[idx] = nums[i];
          }
        }
        return idx+1;
        
    }
}