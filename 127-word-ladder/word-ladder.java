import java.util.*;

class Info {
    String word;
    int steps;

    public Info(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(beginWord, 1));

        while (!q.isEmpty()) {
            Info curr = q.poll();
            String word = curr.word;

            if (word.equals(endWord)) {
                return curr.steps;
            }

            // Try all one-letter transformations
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] == c) continue;

                    chars[i] = c;
                    String nextWord = new String(chars);

                    if (wordSet.contains(nextWord)) {
                        wordSet.remove(nextWord); // Mark as visited
                        q.add(new Info(nextWord, curr.steps + 1));
                    }
                }
            }
        }

        return 0; // If no path found
    }
}
