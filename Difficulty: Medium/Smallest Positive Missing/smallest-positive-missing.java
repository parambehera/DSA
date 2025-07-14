class Solution {
    public int missingNumber(int[] arr) {
        // code here
        HashSet <Integer> set = new HashSet <>();
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int i =1;
        while(true){
            if(!set.contains(i)){
                return i;
            }
            i++;
        
        }
    }
}
