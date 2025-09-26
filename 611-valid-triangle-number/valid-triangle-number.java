class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt =0;
     int n = nums.length;
     for(int i=0;i<n;i++){
        for(int j =i+1;j<n-1;j++){
            int sum =nums[i]+nums[j];
            int idx = Arrays.binarySearch(nums, j+1, n,sum);
            if(idx<0){
                idx = -idx-1;
            }
            else{
                while(idx-1 >=0 && nums[idx-1]==sum){
                    idx--;
                }
            }
            if(idx<=j) continue;
            cnt+=(idx-j-1);
        }
       
     }
      return cnt;
    }
}