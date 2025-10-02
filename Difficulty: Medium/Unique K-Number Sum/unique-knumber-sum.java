class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ArrayList<ArrayList<Integer>> flist = new ArrayList<>();
        helper(flist, new ArrayList<>(), k, n, 1);
        return flist;
    }
   private void helper(ArrayList<ArrayList<Integer>> flist, List<Integer> list, int k, int n, int start) {
        // Base case: if we used exactly k numbers and sum = 0
        if (list.size() == k && n == 0) {
            flist.add(new ArrayList<>(list));
            return;
        }

        // If size > k or sum < 0, no need to continue
        if (list.size() > k || n < 0) {
            return;
        }

        // Choose numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(flist, list, k, n - i, i + 1);  // move to next number
            list.remove(list.size() - 1);          // backtrack
        }
}
}