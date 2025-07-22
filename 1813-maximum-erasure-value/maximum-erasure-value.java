class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int globalSum = 0, localSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            localSum += num;

            // Shrink window until no duplicates
            while (map.get(num) > 1) {
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                localSum -= leftNum;
                left++;
            }

            globalSum = Math.max(globalSum, localSum);
        }

        return globalSum;
    }
}
