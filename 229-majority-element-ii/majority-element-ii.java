import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int el1 = 0, el2 = 1; // initialize differently to avoid confusion
        int cnt1 = 0, cnt2 = 0;

        // 1st pass: find potential candidates
        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
            else if (cnt1 == 0) {
                el1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                el2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // 2nd pass: check actual counts
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }

        List<Integer> res = new ArrayList<>();
        if (cnt1 > n / 3) res.add(el1);
        if (cnt2 > n / 3) res.add(el2);
        return res;
    }
}
