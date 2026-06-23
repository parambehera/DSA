import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2: Use a min heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Fixed typo: changed 'entreySet()' to 'entrySet()'
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Removes the element with the lowest frequency
            }
        }

        // Step 3: Extract elements from the min-heap into the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        
        return result;
    }
}
