class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList <Integer> list = new ArrayList <>();
         list.clear();
        int n = arr.length;
        int max = arr[n-1];
        // list.add(max);
        for(int i =n-1;i>=0;i--){
            if(arr[i]>=max){
                list.add(arr[i]);
            }
            max = Math.max(arr[i],max);
        }
         Collections.reverse(list);
         return list;
    }
}
