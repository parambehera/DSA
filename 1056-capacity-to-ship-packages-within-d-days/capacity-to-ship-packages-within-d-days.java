class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int lb =Integer.MIN_VALUE;
     for(int i=0;i<weights.length;i++){
        lb = Math.max(weights[i],lb);
     }
     int hb =0;
     for(int i=0;i<weights.length;i++){
        hb+=weights[i];
     }
     int ans =-1;
     while(lb<=hb){
        int mid = lb+(hb-lb)/2;
        if(isPossible(weights,days,mid)){
            ans = mid;
            hb = mid-1;
        }else{
            lb = mid+1;
        }
     }
     return ans;
    }
    public boolean isPossible(int[] weights, int days, int cap) {
        int sum = 0;
        int tdays = 1; // at least 1 day required

        for (int w : weights) {
            if (sum + w > cap) { // need new day
                tdays++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return tdays <= days;
    }
}