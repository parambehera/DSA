class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int sum = 0;
        int count = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            count++;

            if (count % 3 != 0) { // pay for first two candies
                sum += cost[i];
            }
            // every 3rd candy is free
        }

        return sum;
    }
}