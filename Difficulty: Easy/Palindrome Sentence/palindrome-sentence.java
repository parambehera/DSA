class Solution {
    public boolean isPalinSent(String s) {
        StringBuilder st = new StringBuilder();
        
        // Filter only alphanumeric characters and convert to lowercase
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || 
                (ch >= 'a' && ch <= 'z') || 
                (ch >= '0' && ch <= '9')) {
                st.append(Character.toLowerCase(ch));
            }
        }
        
        // Check palindrome
        for (int i = 0, j = st.length() - 1; i <= j; i++, j--) {
            if (st.charAt(i) != st.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
