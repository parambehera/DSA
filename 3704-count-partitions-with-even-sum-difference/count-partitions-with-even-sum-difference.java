class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int prefix[]= new int [n];
        prefix[0] = nums[0];
        for(int i =1;i<n;i++){
          prefix[i] = prefix[i-1]+nums[i];
        }
        int count=0;
        int sum = prefix[n-1];
        for(int i =0;i<n-1;i++){
            int s1 = prefix[i];
            int s2 = Math.abs(sum-s1);
            int diff = Math.abs(s1-s2);
            if(diff % 2 ==0){
                count++;
            }
        }
        return count;
    }
}