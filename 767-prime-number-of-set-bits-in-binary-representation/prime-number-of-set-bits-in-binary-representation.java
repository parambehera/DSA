class Solution {
    public int countPrimeSetBits(int left, int right) {
        int max = (int) (Math.floor(Math.log(right) / Math.log(2))) + 1;
        boolean isPrime[] = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int i = left;
        int count = 0;
        while (i <= right) {
            int setBits = Integer.bitCount(i);
            if (isPrime[setBits]) {
                count++;
            }
            i++;
        }
        return count;

    }
}