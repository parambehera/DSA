class Solution {
    int missingNum(int arr[]) {
        // code here
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        HashSet <Integer> set = new HashSet <>();
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int st =1;
        while(st<=max){
            if(!set.contains(st)){
                return st;
            }
            st++;
        }
        return max+1;
    }
}