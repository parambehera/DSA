class Solution {
    static final long MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
      int n = complexity.length;

        // Step 1: Check if complexity[0] is the smallest
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0; // impossible to unlock that computer
            }
        }

        // Step 2: Answer is (n-1)! % MOD
        long fact = 1;
        for (int i = 1; i <= n - 1; i++) {
            fact = (fact * i) % MOD;
        }

        return (int) fact;
    }
}