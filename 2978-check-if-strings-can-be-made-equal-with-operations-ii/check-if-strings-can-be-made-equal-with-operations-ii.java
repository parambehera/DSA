class Solution {
    public boolean checkStrings(String s1, String s2) {
        StringBuilder s1Even = new StringBuilder();
        StringBuilder s1Odd = new StringBuilder();
        StringBuilder s2Even = new StringBuilder();
        StringBuilder s2Odd = new StringBuilder();

        // Build even & odd strings
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                s1Even.append(s1.charAt(i));
                s2Even.append(s2.charAt(i));
            } else {
                s1Odd.append(s1.charAt(i));
                s2Odd.append(s2.charAt(i));
            }
        }

        // Convert to char arrays
        char[] a = s1Even.toString().toCharArray();
        char[] b = s2Even.toString().toCharArray();
        char[] c = s1Odd.toString().toCharArray();
        char[] d = s2Odd.toString().toCharArray();

        // Sort all
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        java.util.Arrays.sort(c);
        java.util.Arrays.sort(d);

        // Compare
        return java.util.Arrays.equals(a, b) &&
               java.util.Arrays.equals(c, d);
    }
}