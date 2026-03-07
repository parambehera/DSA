class Solution {
    public int minPlatform(int arr[], int dep[]) {
             
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0;
        int j=0;
        int n = arr.length;
        int cnt =0;
        int max = 0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                i++;
                cnt++;
            }else{
                j++;
                cnt--;
            }
            max = Math.max(cnt,max);
            
        }
        return max;
        //  code here
        
    }
}
