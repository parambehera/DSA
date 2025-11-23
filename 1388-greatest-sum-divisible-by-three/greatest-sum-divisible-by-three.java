class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int min1 = Integer.MAX_VALUE;        // smallest remainder-1
        int min2 = Integer.MAX_VALUE;        // smallest remainder-2
        int min11 = Integer.MAX_VALUE;       // second smallest remainder-1
        int min22 = Integer.MAX_VALUE;       // second smallest remainder-2

        for (int x : nums) {
            sum += x;
            int r = x % 3;
            if (r == 1) {
                if (x < min1) { min11 = min1; min1 = x; }
                else if (x < min11) min11 = x;
            } else if (r == 2) {
                if (x < min2) { min22 = min2; min2 = x; }
                else if (x < min22) min22 = x;
            }
        }

        int rem = sum % 3;
        if (rem == 0) return sum;

        int remove = Integer.MAX_VALUE;
        if (rem == 1) {
            remove = Math.min(min1, min2 == Integer.MAX_VALUE || min22 == Integer.MAX_VALUE ? Integer.MAX_VALUE : min2 + min22);
        } else { // rem == 2
            remove = Math.min(min2, min1 == Integer.MAX_VALUE || min11 == Integer.MAX_VALUE ? Integer.MAX_VALUE : min1 + min11);
        }

        return remove == Integer.MAX_VALUE ? 0 : sum - remove;
    }
}