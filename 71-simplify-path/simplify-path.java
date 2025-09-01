import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // skip empty or "."
                continue;
            } else if (part.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop(); // go up one directory
                }
            } else {
                st.push(part); // valid directory name
            }
        }

        // Build simplified path
        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
