class Solution {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = binarySearch(list, nums[i]);
            ans[i] = idx;
            list.add(idx, nums[i]); // insert element at correct position
        }

        for (int num : ans) {
            res.add(num);
        }

        return res;
    }

    private int binarySearch(List<Integer> list, int key) {
        int start = 0, end = list.size();
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
