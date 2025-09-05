class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList); // store words for O(1) lookup
        if (!dict.contains(endWord)) return 0;      // endWord must be in dict

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1; // startWord counts as step 1

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return steps;

                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[i] = c;
                        String next = new String(arr);

                        if (dict.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                    }
                    arr[i] = original; // restore original char
                }
            }
            steps++;
        }
        return 0;
    }
}
