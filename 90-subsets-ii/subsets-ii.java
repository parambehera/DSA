import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // ✅ must sort
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int index, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        
        ans.add(new ArrayList<>(path)); // ✅ add every subset

        for (int i = index; i < nums.length; i++) {

            // ✅ skip duplicates at same level
            if (i > index && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);              // take
            solve(i + 1, nums, path, ans); // move forward
            path.remove(path.size() - 1);  // backtrack
        }
    }
}