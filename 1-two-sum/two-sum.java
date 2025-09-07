class Solution {
    public int[] twoSum(int[] nums, int target) {
    //   int a[]=new int[2];
    //   int sum=0;
    //   for(int i=0;i<nums.length;i++){
    //       for(int j=i+1;j<nums.length;j++){
    //           if(nums[i]+nums[j]==target){
    //               a[0]=i;
    //               a[1]=j;
    //           }
    //       }

    //   }
    //   return a;
    
    Map <Integer,Integer> map = new HashMap<>();

    int n = nums.length;
    for(int i =0;i<n;i++){
        map.put(nums[i],i);
    }
    for(int i =0;i<n;i++){
       int diff = target-nums[i];
     if(map.containsKey(diff) && map.get(diff)!=i){
        return new int [] {i,map.get(diff)};
     }
    }
    return new int[]{};
    }
}