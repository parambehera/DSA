class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        helper(0, arr, new ArrayList<Integer>(), k);
        return res;
    }
    
    public void helper(int i, int arr[], List<Integer> list, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list)); 
            return;
        }
        
        for (int j = i; j < arr.length; j++) {
            list.add(arr[j]);                   // choose
            helper(j + 1, arr, list, k);        // ✅ move forward
            list.remove(list.size() - 1);       // undo
        }
    }
}
