class Solution {
    public int binaryGap(int n) {
        int prevIndex = -1;   // previous 1 position
        int currIndex = 0;    // current bit position
        int maxDist = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // check last bit
                if (prevIndex != -1) {
                    maxDist = Math.max(maxDist, currIndex - prevIndex);
                }
                prevIndex = currIndex;
            }
            n = n >> 1;   // shift right
            currIndex++;
        }

        return maxDist;
    }
}