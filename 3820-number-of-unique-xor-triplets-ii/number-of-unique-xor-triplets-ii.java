// import java.util.*;

// class Solution {
//     public int uniqueXorTriplets(int[] nums) {

//         HashSet<Integer> pairXor = new HashSet<>();

//         // Store all possible XORs of two numbers
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = 0; j < nums.length; j++) {
//                 pairXor.add(nums[i] ^ nums[j]);
//             }
//         }

//         HashSet<Integer> tripletXor = new HashSet<>();

//         // XOR every pair XOR with every number
//         for (int xor : pairXor) {
//             for (int num : nums) {
//                 tripletXor.add(xor ^ num);
//             }
//         }

//         return tripletXor.size();
//     }
// }


class Solution {
    public int uniqueXorTriplets(int[] nums) {

        // Maximum possible XOR value (nums[i] <= 1500 < 2048)
        boolean[] pair = new boolean[2048];

        int n = nums.length;

        // Store all possible XORs of two numbers
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        // Store all possible XORs of three numbers
        boolean[] triplet = new boolean[2048];

        for (int x = 0; x < 2048; x++) {
            if (!pair[x]) continue;

            for (int num : nums) {
                triplet[x ^ num] = true;
            }
        }

        int ans = 0;
        for (boolean b : triplet) {
            if (b) ans++;
        }

        return ans;
    }
}