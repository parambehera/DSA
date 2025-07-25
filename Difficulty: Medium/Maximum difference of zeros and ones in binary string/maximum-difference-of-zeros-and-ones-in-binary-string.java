class Solution {
    int maxSubstring(String S) {
        char[] s = S.toCharArray();
        int[] c = new int[S.length()];
        
        for (int i = 0; i < s.length; i++) {
            c[i] = s[i] == '0' ? 1 : -1;
        }

        int gs = 0;  // global sum (max so far)
        int ls = 0;  // local sum (current max ending here)

        for (int i = 0; i < c.length; i++) {
            ls += c[i];
            if (ls < 0) ls = 0;
            gs = Math.max(gs, ls);
        }

        return gs==0?-1:gs;
    }
}
