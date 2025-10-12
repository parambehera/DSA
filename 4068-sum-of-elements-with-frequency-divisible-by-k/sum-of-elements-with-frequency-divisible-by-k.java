class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap <Integer,Integer>map=new HashMap <>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            int freq = map.get(nums[i]);
            if(freq%k==0)sum+=nums[i];
        }
        return sum;
    }
}