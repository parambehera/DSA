class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        char ch[] = {'(', ')'};
        helper(0, n, sb, ch);
        return list;
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else { // ch == ')'
                if (st.isEmpty()) return false;
                if (st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public void helper(int i, int n, StringBuilder sb, char ch[]) {
        if (i == 2 * n) {   // must be 2n length
            if (isValid(sb.toString())) {
                list.add(sb.toString());
            }
            return;
        }
        for (int j = 0; j < ch.length; j++) {
            sb.append(ch[j]);  // fix from ch[i] → ch[j]
            helper(i + 1, n, sb, ch);
            sb.deleteCharAt(sb.length() - 1); // fix sb.size() → sb.length()
        }
    }
}
