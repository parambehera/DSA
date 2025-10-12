import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int len = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (isBalance(map)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    public boolean isBalance(HashMap<Character, Integer> map) {
        int val = -1;
        for (int count : map.values()) {
            if (val == -1) val = count;
            else if (val != count) return false;
        }
        return true;
    }
}
