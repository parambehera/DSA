class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList <Integer> list = new ArrayList <>();
        HashSet <Integer> set = new HashSet <>();
        for(int i =0;i<n;i++){
            if(set.contains(arr[i])){
                list.add(arr[i]);
            }
            set.add(arr[i]);
        }
        int i=1;
        while(i<=n){
            if(!set.contains(i)){
                list.add(i);
            }
            i++;
        }
        return list;
    }
}
