class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int lb =1;
        int hb =stalls[stalls.length-1]-stalls[0];
        int ans = 0;
        while(lb<=hb){
            int mid = lb+(hb-lb)/2;
            if(isPossible(stalls,k,mid)){
                ans = mid;
                lb = mid+1;
            }else{
                hb = mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int stalls[],int k,int dist){
        k--;
        int prev = 0;
        for(int i =1;i<stalls.length;i++){
            if(Math.abs(stalls[i]-stalls[prev])>=dist){
                k--;
                prev = i;
            }
        }
        return k<=0;
    }
}