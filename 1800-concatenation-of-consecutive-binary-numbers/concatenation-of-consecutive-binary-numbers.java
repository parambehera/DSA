class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;
        long result = 0;
        int bits = 0;
        
        for (int i = 1; i <= n; i++) {
            
            // If i is power of 2 → increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }
            
            // Shift left and add i
            result = ((result << bits) + i) % mod;
        }
        
        return (int) result;
    }
}
