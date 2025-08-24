class Solution {
    public int longestSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int n = nums.length;
        int len = 0;

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

         
            while (map.containsKey(0) && map.get(0) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
