class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int res[]= new int[n];
        for(int i=0;i<n;i++){
            int k  =nums[i];
          int finali = ((i + k) % n + n) % n;
           res[i] = nums[finali];
        }
       return res;
    }
}