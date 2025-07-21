import java.util.*;

class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) return s;

        List<Integer> removeIndices = new ArrayList<>();
        Map<Character, Integer> freq = new HashMap<>();

        // Initialize first window
        for (int i = 0; i < 3; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Check only the first character of the window
        if (freq.get(s.charAt(0)) == 3) {
            removeIndices.add(2); // remove last char of the window
        }

        // Sliding window
        for (int i = 3; i < s.length(); i++) {
            char outChar = s.charAt(i - 3); // char leaving the window
            char inChar = s.charAt(i);      // char entering the window

            // update map
            freq.put(outChar, freq.get(outChar) - 1);
            if (freq.get(outChar) == 0) freq.remove(outChar);

            freq.put(inChar, freq.getOrDefault(inChar, 0) + 1);

            // ✅ check only the 1st char of current window
            char windowFirstChar = s.charAt(i - 2);
            if (freq.get(windowFirstChar) == 3) {
                removeIndices.add(i); // mark for removal
            }
        }

        // Build final result
        Set<Integer> toRemove = new HashSet<>(removeIndices);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
