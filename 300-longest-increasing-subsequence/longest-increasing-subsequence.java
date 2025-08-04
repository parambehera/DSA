import java.util.*;

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         Integer[][] dp = new Integer[n][n + 1]; // last can be -1 (n positions total)
//         return helper(nums, 0, -1, dp);
//     }

//     public int helper(int[] nums, int idx, int lastIdx, Integer[][] dp) {
//         if (idx == nums.length) return 0;

//         if (dp[idx][lastIdx + 1] != null) return dp[idx][lastIdx + 1];

//         int notTake = helper(nums, idx + 1, lastIdx, dp);
//         int take = Integer.MIN_VALUE;
//         if (lastIdx == -1 || nums[idx] > nums[lastIdx]) {
//             take = 1 + helper(nums, idx + 1, idx, dp);
//         }

//         return dp[idx][lastIdx + 1] = Math.max(take, notTake);
//     }
// }

// class Solution {
//       public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int dp[]= new int [n];
//         Arrays.fill(dp,1);
//         int max = Integer.MIN_VALUE;
//         for(int i =0;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[j]<nums[i]){
//                     dp[i] =Math.max(dp[j]+1,dp[i]);
//                 }
//                 max = Math.max(max,dp[i]);
//             }
//         }
//         return max==Integer.MIN_VALUE?1:max;
//       }
// }

class Solution {
      public int lengthOfLIS(int[] nums) {
            List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int index = Collections.binarySearch(tails, num);

            if (index < 0) {
                index = -index - 1; // Insertion point
            }

            if (index == tails.size()) {
                tails.add(num); // Extend the sequence
            } else {
                tails.set(index, num); // Replace to maintain minimal tail
            }
        }

        return tails.size();
      }
}