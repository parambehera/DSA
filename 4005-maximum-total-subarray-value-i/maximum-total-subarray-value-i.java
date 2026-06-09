class Solution {
    public long maxTotalValue(int[] nums, int k) {
      Arrays.sort(nums);
        int n = nums.length;
    long val = nums[n-1]-nums[0];
        return val*k;
       
    }
}