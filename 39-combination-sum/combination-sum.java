class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, 0, new ArrayList<>(), target);
        return res;
    }

    public void helper(int[] candidates, int sum, int start, List<Integer> list, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = start; j < candidates.length; j++) {
            int num = candidates[j];
            if (sum + num <= target) {
                list.add(num);                    // choose
                helper(candidates, sum + num, j, list, target); // reuse j
                list.remove(list.size() - 1);     // undo
            }
        }
    }
}
