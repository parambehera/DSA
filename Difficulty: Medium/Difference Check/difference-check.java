class Solution {
    
    public int minDifference(String[] arr) {
        // code here
        int n = arr.length;
        int seconds[]= new int[n];
        for(int i =0;i<n;i++){
            String[] sp = arr[i].split(":");
            int hr = Integer.parseInt(sp[0]);
            int min = Integer.parseInt(sp[1]);
            int se = Integer.parseInt(sp[2]);
            int total = (hr*3600)+(min*60)+se;
            seconds[i] = total;
        }
        Arrays.sort(seconds);
         int minDiff = Integer.MAX_VALUE;
        
        // Check consecutive differences
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }
        
        // Wrap-around difference (last to first across midnight)
        int wrapDiff = (86400 - seconds[n - 1]) + seconds[0];
        minDiff = Math.min(minDiff, wrapDiff);
        
        return minDiff;
    }
}
