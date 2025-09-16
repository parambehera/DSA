import java.util.*;

class Solution {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for (String s : arr) {
            if ("+-*/^".contains(s)) {
                int b = st.pop();
                int a = st.pop();

                switch (s) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": 
                        int div = a / b;
                        // adjust for floor division when negative
                        if ((a ^ b) < 0 && a % b != 0) div--; 
                        st.push(div);
                        break;
                    case "^": st.push((int)Math.pow(a, b)); break;
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}
