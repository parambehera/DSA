class Solution {
    int mod = 1000000007;

    public int permutationCoeff(int n, int k) {
        long factN = 1;
        for (int i = 1; i <= n; i++) {
            factN = (factN * i) % mod;
        }

        long factNK = 1;
        for (int i = 1; i <= (n - k); i++) {
            factNK = (factNK * i) % mod;
        }

        long res = (factN * moduloInv(factNK)) % mod;
        return (int) res;
    }

    // Modular Inverse using Recursive Binary Exponentiation
    public long moduloInv(long a) {
        return binExpo(a, mod - 2);
    }

    // Recursive Binary Exponentiation
    public long binExpo(long x, long y) {
        if (y == 0) return 1;
        long temp = binExpo(x, y / 2);
        long res = (temp * temp) % mod;
        if (y % 2 == 1) {
            res = (res * x) % mod;
        }
        return res;
    }
}
