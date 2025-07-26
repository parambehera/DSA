// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         if(n == 2) return Math.max(nums[0], nums[1]);

//         // Case 1: Rob from 0 to n-2 (exclude last house)
//         int[] dp1 = new int[n];
//         dp1[0] = nums[0];
//         dp1[1] = Math.max(nums[0], nums[1]);
//         for(int i = 2; i < n - 1; i++) {
//             dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
//         }

//         // Case 2: Rob from 1 to n-1 (exclude first house)
//         int[] dp2 = new int[n];
//         dp2[1] = nums[1];
//         for(int i = 2; i < n; i++) {
//             dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
//         }

//         return Math.max(dp1[n - 2], dp2[n - 1]);
//     }
// }
//or
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}
