class Solution {
    public int minRemoval(int[] nums, int k) {
    Arrays.sort(nums);
     int left =0;
     int right =0;
     int n = nums.length;
     int len= 0;
    
     while(left<=right && right<n){
         int min= nums[left];
         int max = nums[right];
         while (left <= right && (long) nums[right] > (long) k * nums[left]) {
                left++;
            }
           
            len = Math.max(len, right - left + 1);
             right++;
     }
     int minRemove =n-len;
     return minRemove;

    }
}