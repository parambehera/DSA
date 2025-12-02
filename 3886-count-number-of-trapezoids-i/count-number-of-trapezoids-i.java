import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> yCount = new HashMap<>();

        for (int[] p : points) {
            int y = p[1];
            yCount.put(y, yCount.getOrDefault(y, 0) + 1);
        }

        List<Long> pairCounts = new ArrayList<>();
        for (int count : yCount.values()) {
            if (count >= 2) {
                long c2 = (long) count * (count - 1) / 2;
                pairCounts.add(c2);
            }
        }

        long sum = 0, squareSum = 0;
        for (long c : pairCounts) {
            sum = (sum + c) % MOD;
            squareSum = (squareSum + c * c % MOD) % MOD;
        }

        long result = (sum * sum % MOD - squareSum + MOD) % MOD;
        result = result * modInverse(2, MOD) % MOD;

        return (int) result;
    }

    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
