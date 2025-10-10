class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int arr[]= new int [k];
        for(int i=0;i<k;i++){
            arr[i] = energy[i];
        }
        for(int i=k;i<n;i++){
            int idx = i%k;
            int prev = arr[idx];
            if(prev+energy[i]>energy[i]){
                arr[idx] = prev+energy[i];
            }else{
                arr[idx] = energy[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}