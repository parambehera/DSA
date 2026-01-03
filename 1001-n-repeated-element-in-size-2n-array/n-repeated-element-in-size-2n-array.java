class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len/2]==nums[len/2+1]?nums[len/2]:nums[len/2-1];
    }
}