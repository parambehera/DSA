// class Solution {
//     public int minimumDistance(int[] nums) {
//        int n = nums.length;
//        int min = Integer.MAX_VALUE;
//        for(int i=0;i<n;i++){
//         for(int j = i+1;j<n;j++){
//             for(int k= j+1;k<n;k++){
//                 if(nums[i]==nums[j] && nums[j]==nums[k]){
//                     int sum =Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
//                     min = Math.min(sum,min);
//                 }
//             }
//         }
//        }
//        return min==Integer.MAX_VALUE ? -1 :min;

//     }
// }

// import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        // Step 2: check each value
        for (ArrayList<Integer> list : map.values()) {

            if (list.size() < 3) continue;

            // check consecutive triplets
            for (int i = 0; i <= list.size() - 3; i++) {
                int first = list.get(i);
                int third = list.get(i + 2);

                int distance = 2 * (third - first);
                ans = Math.min(ans, distance);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}