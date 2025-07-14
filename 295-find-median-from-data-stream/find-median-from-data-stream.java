class MedianFinder {
    PriorityQueue<Integer> left;  // max-heap
    PriorityQueue<Integer> right; // min-heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        right = new PriorityQueue<>(); // min-heap
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Balance the heaps
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek(); // left will always have equal or one more element
        }
    }
}
