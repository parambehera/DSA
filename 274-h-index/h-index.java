class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lb =0;
        int hb = n;
        int ans =0;
        while(lb<=hb){
            int mid = lb+(hb-lb)/2;
            if(isPossible(citations,mid)){
              ans = mid;
              lb= mid+1;
            }else{
              hb = mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int []citations,int h){
        int cnt =0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=h) cnt++;
        }
        return cnt>=h;
    }
}