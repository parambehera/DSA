import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // A list to store the powers of 2 that sum up to n.
        ArrayList<Integer> powers = new ArrayList<>();
        int mod = 1_000_000_007; // Correct way to define the modulus.

        // --- Correct Logic to find powers of 2 for n ---
        // This finds the set bits in the binary representation of n.
        for (int i = 0; i < 32; i++) {
            // Check if the i-th bit is set
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i); // (1 << i) is an efficient way to calculate 2^i
            }
        }
        // The `powers` array is already sorted, so Collections.sort() is not needed.

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // Correctly access the query bounds for the i-th query.
            int left = queries[i][0];
            int right = queries[i][1];

            // Use 'long' for the product to prevent overflow before applying the modulus.
            long product = 1;
            for (int j = left; j <= right; j++) {
                // Correct way to perform modular multiplication.
                // Typo 'power' corrected to 'powers'.
                product = (product * powers.get(j)) % mod;
            }
            ans[i] = (int) product;
        }

        // --- Add the missing return statement ---
        return ans;
    }
}