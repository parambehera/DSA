class Solution {

    class Pair {
        int value;
        int row;
        int col;

        Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        int currentMax = Integer.MIN_VALUE;

        // Put the first element of every list into the heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new Pair(val, i, 0));
            currentMax = Math.max(currentMax, val);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int currentMin = curr.value;

            // Update the answer if we found a smaller range
            if ((currentMax - currentMin < end - start) ||
                (currentMax - currentMin == end - start && currentMin < start)) {

                start = currentMin;
                end = currentMax;
            }

            // Move to the next element in the same list
            int nextCol = curr.col + 1;

            // If one list is exhausted, we cannot cover all lists anymore
            if (nextCol == nums.get(curr.row).size()) {
                break;
            }

            int nextValue = nums.get(curr.row).get(nextCol);

            pq.offer(new Pair(nextValue, curr.row, nextCol));

            // Update the current maximum
            currentMax = Math.max(currentMax, nextValue);
        }

        return new int[]{start, end};
    }
}