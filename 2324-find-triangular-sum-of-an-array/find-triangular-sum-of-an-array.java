class Solution {
    public int triangularSum(int[] nums) {
     ArrayList <Integer> list = new ArrayList <>();
     int n = nums.length;
     for(int i=0;i<n;i++){
        list.add(nums[i]);
     }

     for(int i=1;i<=n;i++){
        for(int j =0;j<n-i;j++){
            // int sum = (list.get(j)+list.get(j+1))%10;
            // list.add(j,sum);
          int sum = (nums[j]+nums[j+1])%10;
          nums[j] = sum;
        }
     }

     return nums[0];
    }
}