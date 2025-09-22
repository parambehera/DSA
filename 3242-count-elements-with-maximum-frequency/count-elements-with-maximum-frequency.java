class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
            }
        }

        // 2. count how many entries have max value
        int cnt = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value == max) {
                cnt++;
            }
        }
        return cnt * max;

    }
}