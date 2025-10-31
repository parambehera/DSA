class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int res []= new int[2];
        HashSet <Integer> set = new HashSet <>();
        int idx =0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                res[idx]= nums[i];
                idx++;
            }
            set.add(nums[i]);
        }
        return res;
    }
}