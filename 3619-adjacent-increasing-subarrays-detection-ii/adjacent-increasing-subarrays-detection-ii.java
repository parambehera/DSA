class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int left = 1, right = n / 2, ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (hasIncreasingSubarrays(nums, mid)) {
                ans = mid; // mid works, try to go higher
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

   public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prevCount =1;
        int currCount = 1;
        int max = 0;
        int n = nums.size();
        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                currCount++; 
            }else{
                prevCount = currCount;
                currCount = 1;
            }
            if(currCount >=2*k){
                return true;
            }
            if(Math.min(currCount,prevCount)>=k){
                return true;
            }
        }
        return false;
    }
}
