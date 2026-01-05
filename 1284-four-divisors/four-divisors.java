class Solution {
    public int sumFourDivisors(int[] nums) {
        int gsum = 0;

        for (int num : nums) {
            int sum = 0;
            int count = 0;

            for (int j = 1; j * j <= num; j++) {
                if (num % j == 0) {
                    int d1 = j;
                    int d2 = num / j;

                    if (d1 == d2) {      // perfect square
                        count += 1;
                        sum += d1;
                    } else {
                        count += 2;
                        sum += d1 + d2;
                    }
                }
            }

            if (count == 4) {
                gsum += sum;
            }
        }
        return gsum;
    }
}
