class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) list1.add(x);
            else if (x % 3 == 2) list2.add(x);
        }

        int rem = sum % 3;
        if (rem == 0) return sum;

        int ans = 0;

        if (rem == 1) {
            int remove1 = Integer.MAX_VALUE;
            int remove2 = Integer.MAX_VALUE;

            if (list1.size() >= 1)
                remove1 = list1.get(0);

            if (list2.size() >= 2)
                remove2 = list2.get(0) + list2.get(1);

            ans = sum - Math.min(remove1, remove2);
        } else { // rem == 2
            int remove1 = Integer.MAX_VALUE;
            int remove2 = Integer.MAX_VALUE;

            if (list2.size() >= 1)
                remove1 = list2.get(0);

            if (list1.size() >= 2)
                remove2 = list1.get(0) + list1.get(1);

            ans = sum - Math.min(remove1, remove2);
        }

        return ans < 0 ? 0 : ans;
    }
}