import java.util.Stack;

class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

          
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } 
            else {
                if (st.isEmpty()) return false; // No matching opening
                if ((ch == '}' && st.peek() == '{') ||
                    (ch == ']' && st.peek() == '[') ||
                    (ch == ')' && st.peek() == '(')) {
                    st.pop();
                } else {
                    return false; // Mismatched pair
                }
            }
        }
        return st.isEmpty(); // All matched
    }
}
