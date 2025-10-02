class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int req = (int) Math.floor(n / 3);
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.isEmpty()) {
                if (cnt > req && list.get(list.size()-1) != nums[i]) {
                    list.add(nums[i]);
                }
            }else{
                if(cnt>req){
                    list.add(nums[i]);
                }
            }
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                cnt++;
            } else if (i < n - 1 && nums[i] != nums[i + 1]) {
                cnt = 1;
            }
        }
        return list;
    }
}