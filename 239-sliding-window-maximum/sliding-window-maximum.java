class Solution { 
    public int[] maxSlidingWindow(int[] nums, int k) { 
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        int n = nums.length; 
        int max = Integer.MIN_VALUE; 
        ArrayList<Integer> list = new ArrayList<>(); 

        for(int i = 0; i < k; i++) { 
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(nums[i], max); 
        } 
        list.add(max); 

        for(int right = k; right < n; right++) { 
            int last = right - k; 
            int ele = nums[last]; 
            if (map.get(ele) == 1) {
                map.remove(ele);
            } else {
                map.put(ele, map.get(ele) - 1);
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            int m = map.lastKey(); 
            list.add(m); 
        } 

        int arr[] = new int[list.size()]; 
        for(int i = 0; i < list.size(); i++) { 
            arr[i] = list.get(i); 
        } 
        return arr; 
    } 
}