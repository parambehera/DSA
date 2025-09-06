class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        helper(nums, new ArrayList<Integer>(), set);
        return res;
    }

    public void helper(int arr[], List<Integer> list, HashSet<Integer> set) {
        if (list.size() == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (set.contains(arr[j])) continue; // ✅ skip used
            list.add(arr[j]);                    // choose
            set.add(arr[j]);                     // mark as used
            helper(arr, list, set);              // recurse
            list.remove(list.size() - 1);        // undo
            set.remove(arr[j]);                  // unmark
        }
    }
}
