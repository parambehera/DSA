// class Solution {
//     public int minimumEffort(int[][] tasks) {

//         Arrays.sort(tasks, (a, b) -> {
//             return (b[1] - b[0]) - (a[1] - a[0]);
//         });

//         int energy = 0;
//         int current = 0;

//         for (int[] task : tasks) {

//             int actual = task[0];
//             int minimum = task[1];

//             if (current < minimum) {
//                 energy += (minimum - current);
//                 current = minimum;
//             }

//             current -= actual;
//         }

//         return energy;
//     }
// }
class Solution {

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );

        int low = 1;
        int high = 0;

        for (int[] task : tasks) {
            high += task[1];
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(tasks, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canFinish(int[][] tasks, int energy) {

        int current = energy;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            if (current < minimum) {
                return false;
            }

            current -= actual;
        }

        return true;
    }
}