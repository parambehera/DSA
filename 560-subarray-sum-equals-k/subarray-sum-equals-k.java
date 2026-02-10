class Solution {
    //  public int subarraySum(int[] nums, int k) {
    //   int n = nums.length;
    //   int cnt =0;
    //   for(int i=0;i<n;i++){
    //     int sum=0;
    //     for(int j =i;j<n;j++){
    //       sum+=nums[j];
    //       if(sum==k)cnt++;
    //     }
    //   } 
    //   return cnt;
    // }
    public int subarraySum(int[] nums, int k) {
       int n = nums.length;
       int cnt =0;
       HashMap <Integer,Integer> map = new HashMap <>();
       int sum=0;
       map.put(0,1);
       for(int i=0;i<n;i++){
        sum+=nums[i];
        cnt+=map.getOrDefault(sum-k,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
       }
      return cnt;
    }
}