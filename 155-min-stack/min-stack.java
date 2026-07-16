import java.util.Stack;

class MinStack {

    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            min = val;
        } else {
            if (val < min) {
                // Store encoded value
                st.push(2L * val - min);
                min = val;
            } else {
                st.push((long) val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }

        long top = st.pop();

        // Encoded value means the current top was the minimum
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = st.peek();

        // Encoded value, actual top is current minimum
        if (top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}