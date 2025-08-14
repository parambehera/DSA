import java.util.HashMap;

class Solution {
    public String largestGoodInteger(String num) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        String ans = "";

        while (right < num.length()) {
            char ch = num.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window if more than 1 unique char
            while (map.size() > 1) {
                char lch = num.charAt(left);
                map.put(lch, map.get(lch) - 1);
                if (map.get(lch) == 0) {
                    map.remove(lch);
                }
                left++;
            }

            // Check for 3 consecutive same digits
            if (map.size() == 1 && map.get(ch) == 3) {
                String curr = num.substring(left, right + 1);
                if (ans.isEmpty() || curr.compareTo(ans) > 0) {
                    ans = curr;
                }
            }
            right++;
        }

        return ans;
    }
}
