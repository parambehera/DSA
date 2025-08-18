class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // ascending order
        int n = citations.length;
        int maxCitation = citations[n - 1];
        
        for (int h = maxCitation; h >= 0; h--) {
            int index = Arrays.binarySearch(citations, h);
            if (index < 0) {
                index = -index - 1; // insertion point
            } else {
                // binarySearch can return any index of multiple occurrences,
                // move left to find first occurrence
                while (index > 0 && citations[index - 1] >= h) {
                    index--;
                }
            }
            if (n - index >= h) {
                return h;
            }
        }
        return 0;
    }
}
