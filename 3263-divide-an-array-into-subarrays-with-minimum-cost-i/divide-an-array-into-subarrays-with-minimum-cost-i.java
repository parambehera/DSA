class Solution {
    public int minimumCost(int[] nums) {
        int sum =nums[0];
        nums[0]=0;
        Arrays.sort(nums);
        return sum+nums[1]+nums[2];
    }
}