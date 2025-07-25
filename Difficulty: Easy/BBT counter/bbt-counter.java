// User-defined Solution class

class Solution {
    public int countBT(int h) {
        // code here
         int mod = 1000000007;

    if (h == 0 || h == 1) return 1;

    int x = countBT(h - 1);
    int y = countBT(h - 2);

    long res = (1L * x * x + 2L * x * y) % mod;
    return (int) res;
    }
}
