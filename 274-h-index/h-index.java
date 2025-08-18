class Solution {
    public int hIndex(int[] citations) {
          Arrays.sort(citations); // ascending order
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i; // number of papers with citations >= citations[i]
            if (citations[i] >= h) { // H-index must be exactly present
                return h;
            }
        }

        return 0; // No exact match found
    }
}