class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean leftSame = (mid > 0 && nums[mid] == nums[mid - 1]);
            boolean rightSame = (mid < n - 1 && nums[mid] == nums[mid + 1]);

            // ✅ single element
            if (!leftSame && !rightSame) {
                return nums[mid];
            }

            // ✅ pair with right
            if (rightSame) {
                int rightSize = high - (mid + 1);

                if (rightSize % 2 == 0) {
                    high = mid - 1;   // go left
                } else {
                    low = mid + 2;    // go right
                }
            }

            // ✅ pair with left
            else {
                int leftSize = (mid - 1) - low;

                if (leftSize % 2 == 0) {
                    low = mid + 1;    // go right
                } else {
                    high = mid - 2;   // go left
                }
            }
        }

        return -1;
    }
}