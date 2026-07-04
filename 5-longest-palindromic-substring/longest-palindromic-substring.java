class Solution {
    public String longestPalindrome(String s) {
        int st = 0;
        int maxLen = 1;

        for (int i = 1; i < s.length(); i++) {
            // Check for even-length palindrome (center between i-1 and i)
            int l = i - 1, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > maxLen) {
                    maxLen = r - l + 1;
                    st = l;
                }
                l--;
                r++;
            }

            // Check for odd-length palindrome (centered at i)
            int q = i - 1, j = i + 1;
            while (q >= 0 && j < s.length() && s.charAt(q) == s.charAt(j)) {
                if ((j - q + 1) > maxLen) {
                    maxLen = j - q + 1;
                    st = q;
                }
                q--;
                j++;
            }
        }
        return s.substring(st, st + maxLen);
    }
}
