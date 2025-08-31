class Solution {
    public int maxWater(int arr[]) {
        // Code Here
       int rp = arr.length-1;
        int lp= 0;
        int area =0;
        while(lp<rp){
            int lh = arr[lp];
            int rh = arr[rp];
            int hight = Math.min(lh,rh);
            int width = rp-lp;
            area = Math.max(hight*width,area);
            if(lh>rh)rp--;
            else lp++;
        }
        return area;
    }
}