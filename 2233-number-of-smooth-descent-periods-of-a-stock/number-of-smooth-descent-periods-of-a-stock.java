class Solution {
    public long getDescentPeriods(int[] prices) {
        long cnt = 1;   // first day itself
        long len = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                len++;
            } else {
                len = 1;
            }
            cnt += len;
        }

        return cnt;
    }
}
