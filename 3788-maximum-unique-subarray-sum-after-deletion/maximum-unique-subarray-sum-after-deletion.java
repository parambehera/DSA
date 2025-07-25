class Solution {
    public int maxSum(int[] nums) {
        HashSet <Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(nums[i]>=0){
                set.add(nums[i]);
            }
        }
        if(max<0){
            return max;
        }
        int sum =0;
        for(int num : set){
            sum += num;
        }
        return sum;
        
    }
}