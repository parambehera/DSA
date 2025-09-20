import java.util.Stack;

class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];

        // Initialize
        for (int i = 0; i < n; i++) {
            nextGreater[i] = n;  // no greater element to right
            prevGreater[i] = -1; // no greater element to left
        }

        Stack<Integer> st = new Stack<>();

        // Find next greater element to the right
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }

        // Clear stack for previous greater
        st.clear();

        // Find previous greater element to the left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }

        // Find maximum valid subarray length
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int windowSize = nextGreater[i] - prevGreater[i] - 1;
            if (windowSize >= arr[i]) {
                maxLength = Math.max(maxLength, windowSize);
            }
        }

        return maxLength;
    }

    // Quick test
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3};
        System.out.println(longestSubarray(arr)); // Output: 4
    }
}
