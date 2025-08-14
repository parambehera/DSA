// import java.util.HashMap;

// class Solution {
//     public String largestGoodInteger(String num) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         int left = 0;
//         int right = 0;
//         String ans = "";

//         while (right < num.length()) {
//             char ch = num.charAt(right);
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//             // Shrink window if more than 1 unique char
//             while (map.size() > 1) {
//                 char lch = num.charAt(left);
//                 map.put(lch, map.get(lch) - 1);
//                 if (map.get(lch) == 0) {
//                     map.remove(lch);
//                 }
//                 left++;
//             }

//             // Check for 3 consecutive same digits
//             if (map.size() == 1 && map.get(ch) == 3) {
//                 String curr = num.substring(left, right + 1);
//                 if (ans.isEmpty() || curr.compareTo(ans) > 0) {
//                     ans = curr;
//                 }
//             }
//             right++;
//         }

//         return ans;
//     }
// }.


class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);
            if (c1 == c2 && c2 == c3) {
                String curr = "" + c1 + c2 + c3;
                if (ans.isEmpty() || curr.compareTo(ans) > 0) {
                    ans = curr;
                }
            }
        }
        return ans;
    }
}


