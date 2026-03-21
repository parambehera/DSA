class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    public void helper(List<List<String>> ans, List<String> list, String s, int idx) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);

            if (isPalindrome(sub)) {
                list.add(sub);                  // choose
                helper(ans, list, s, i + 1);    // explore
                list.remove(list.size() - 1);   // backtrack
            }
        }
    }

    public boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}