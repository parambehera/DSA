class Solution {
    public int kokoEat(int[] arr, int k) {
        int lb =1;
        int hb = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            // lb = Math.min(arr[i],lb);
            hb = Math.max(hb,arr[i]);
        }
        int ans = Integer.MAX_VALUE;
        while(lb<=hb){
            int mid = lb+(hb-lb)/2;
            if(canEat(mid,arr,k)){
                ans = Math.min(mid,ans);
                hb = mid-1;
            }else{
                lb= mid+1;
            }
        }
        return ans;
        
    }
    public boolean canEat(int s,int arr[],int k){
        int sum =0;
        for(int i =0;i<arr.length;i++){
           sum += (int)Math.ceil((double)arr[i] / s);
        }
        return sum<=k;
    }
}

// class Solution {
//     public int kokoEat(int[] arr, int k) {
//         int lb = 1;  // minimum speed
//         int hb = Integer.MIN_VALUE;

//         // find maximum pile for high bound
//         for (int bananas : arr) {
//             hb = Math.max(hb, bananas);
//         }

//         int ans = hb;  // start with max as worst case

//         while (lb <= hb) {
//             int mid = lb + (hb - lb) / 2;

//             if (canEat(mid, arr, k)) {
//                 ans = mid;      // mid is a valid speed
//                 hb = mid - 1;   // try smaller speed
//             } else {
//                 lb = mid + 1;   // need bigger speed
//             }
//         }
//         return ans;
//     }

//     public boolean canEat(int speed, int arr[], int k) {
//         int hours = 0;
//         for (int bananas : arr) {
//             hours += (int)Math.ceil((double)bananas / speed);
//         }
//         return hours <= k;
//     }
// }
