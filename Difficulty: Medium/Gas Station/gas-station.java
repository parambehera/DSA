class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;  // net gas across all stations
        int tank = 0;   // current fuel
        int start = 0;  // candidate start station
        
        for (int i = 0; i < n; i++) {
            int rem = gas[i] - cost[i];
            total += rem;
            tank += rem;
            
            // If tank goes negative, reset start to i+1
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        // If total gas < total cost, impossible
        return total >= 0 ? start : -1;
    }
}
