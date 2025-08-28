class Solution {
    public int majorityElement(int[] nums) {
        // int count = 0;
        // for(int i=0;i<nums.length;i++){
        //     count =0;
        //     for(int j =0;j<nums.length;j++){
        //        if(nums[i]==nums[j]){
        //         count++;
        //        }
        //     }
        //     if(count > Math.ceil(nums.length/2)){
        //         return nums[i];
        //     }
        // }
        // return -1;
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}