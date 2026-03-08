class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        int total = (int)Math.pow(2, len);
        HashSet <String> set = new HashSet <>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < total; i++){
            String binary = Integer.toBinaryString(i);

            while(binary.length() < len){
                binary = "0" + binary;
            }
            if(!set.contains(binary)){
                return binary;
            }
            list.add(binary);
        }
        return "";
        
       
    }
}