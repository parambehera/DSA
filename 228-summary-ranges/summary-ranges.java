class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List <String> list = new ArrayList <>();
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<nums.length-1;i++){
            int curr = nums[i];
            int next = nums[i+1];
            if(curr+1==next){
                if(sb.isEmpty()){
                    sb.append(curr+"->");
                }
            }else{
                sb.append(curr);
                list.add(sb.toString());
                sb = new StringBuilder("");
            }
        }
        if(nums.length>=1){
            list.add(sb.append(nums[nums.length-1]).toString());
        }
             
       return list;
    }
}