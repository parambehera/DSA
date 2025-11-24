class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int num=0;
       List<Boolean> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // num *=2;
            // num +=nums[i];
            num = (num * 2 + nums[i]) % 5;
            if(num%5==0)list.add(true);
            else list.add(false);
        }
        return list;
    }
}