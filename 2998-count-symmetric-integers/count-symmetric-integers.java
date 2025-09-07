class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for (int i = low; i <= high; i++) {
            int len = digitCount(i);
            if (len % 2 == 0 && isSym(i, len)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isSym(int num, int len) {
        int half = len / 2;
        int sum = 0;

        for (int pos = 1; pos <= len; pos++) {
            int digit = num % 10;
            num /= 10;

            if (pos <= half) {
                // right half (last half of digits)
                sum += digit;
            } else {
                // left half (first half of digits)
                sum -= digit;
            }
        }

        return sum == 0;
    }

    private int digitCount(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}
