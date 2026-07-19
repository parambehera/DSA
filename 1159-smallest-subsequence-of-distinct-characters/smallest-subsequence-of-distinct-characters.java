class Solution {
    public String smallestSubsequence(String s) {

        int n = s.length();

        // Store the last occurrence of every character
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // To check whether a character is already in the stack
        boolean[] visited = new boolean[26];

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            // If already included, skip it
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (!st.isEmpty()
                    && st.peek() > ch
                    && last[st.peek() - 'a'] > i) {

                visited[st.peek() - 'a'] = false;
                st.pop();
            }

            st.push(ch);
            visited[ch - 'a'] = true;
        }

        // Build the answer
        StringBuilder ans = new StringBuilder();

        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}