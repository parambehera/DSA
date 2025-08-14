class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        int pre []= new int [n];
        pre[0] = arr[0];
        
        for(int i =1;i<n;i++){
         pre [i] =pre[i-1]+arr[i];
        }
        
        int suf[]  = new int[n];
        suf [n-1] = arr[n-1];
         for(int i =n-2;i>=0;i--){
         suf [i] =suf[i+1]+arr[i];
        }
        
        for(int i =1;i<n-1;i++){
            if(suf[i+1]==pre[i-1]){
                return  i;
            }
        }
        return -1;
    }
}
