

class Solution {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove elements out of this window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements in k range as they are useless
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // Add current element at the end of deque
            dq.offerLast(i);

            // Add to result when the first window is hit
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }

        return result;
    }
}
