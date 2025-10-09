class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
      int prefixSum[]= new int [n];
      int cnt =0;
      prefixSum[0] = nums[0];
      for(int i=1;i<n;i++){
        prefixSum[i] =prefixSum[i-1]+nums[i]; 
      }
      for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int sum=0;
            if(i!=0){
                    sum =prefixSum[j]-prefixSum[i-1];
            }else{
                   sum =prefixSum[j]; 
            }
            if(sum==k){
               cnt++;
            }          
        }
      }
      return cnt;
    }
}