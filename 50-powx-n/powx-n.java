class Solution {
    public double myPow(double x, int n) {
        long exp = n; // use long to handle overflow when n = -2^31
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        return fastPow(x, exp);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
