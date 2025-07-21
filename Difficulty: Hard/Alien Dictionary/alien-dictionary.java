import java.util.*;

class Solution {
    public String findOrder(String[] words) {
        // Initialize graph with 26 characters
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        // Track all unique characters seen
        boolean[] seen = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                seen[c - 'a'] = true;
            }
        }

        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String nxtWord = words[i + 1];
            int len = Math.min(word.length(), nxtWord.length());

            boolean foundDiff = false;
            for (int j = 0; j < len; j++) {
                char cc = word.charAt(j);
                char nc = nxtWord.charAt(j);
                if (cc != nc) {
                    graph.get(cc - 'a').add(nc - 'a');
                    foundDiff = true;
                    break;
                }
            }

            // Edge case: word1 is longer and word1 is a prefix of word2 → invalid order
            if (!foundDiff && word.length() > nxtWord.length()) {
                return "";
            }
        }

        return topologicalString(graph, seen);
    }

    String topologicalString(List<List<Integer>> graph, boolean[] seen) {
        int[] inDeg = new int[26];

        // Build indegree array
        for (int u = 0; u < 26; u++) {
            for (int v : graph.get(u)) {
                inDeg[v]++;
            }
        }

        // Queue for topological sort
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (seen[i] && inDeg[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append((char) (curr + 'a'));

            for (int neigh : graph.get(curr)) {
                inDeg[neigh]--;
                if (inDeg[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        // Check if result contains all seen characters
        for (int i = 0; i < 26; i++) {
            if (seen[i] && sb.indexOf("" + (char) (i + 'a')) == -1) {
                return ""; // Cycle detected
            }
        }

        return sb.toString();
    }
}
