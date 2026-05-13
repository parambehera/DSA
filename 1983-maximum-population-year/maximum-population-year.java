class Solution {
    public int maximumPopulation(int[][] logs) {

        int max = 0;
        int ans = 1950;

        for(int year = 1950; year <= 2050; year++) {

            int cnt = 0;

            for(int[] log : logs) {

                if(year >= log[0] && year < log[1]) {
                    cnt++;
                }
            }

            if(cnt > max) {
                max = cnt;
                ans = year;
            }
        }

        return ans;
    }
}