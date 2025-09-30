class Solution {
    public int triangularSum(int[] nums) {
     int n = nums.length;
     for(int i=1;i<=n;i++){
        for(int j =0;j<n-i;j++){
          int sum = (nums[j]+nums[j+1])%10;
          nums[j] = sum;
        }
     }

     return nums[0];
    }
}