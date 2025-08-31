class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
       int arr[]= new int [friends.length];
       HashSet <Integer> list = new HashSet<>();
       for(int i =0;i<friends.length;i++){
        list.add(friends[i]);
       }
       int j =0;
       for(int i=0;i<order.length;i++){
        if(list.contains(order[i])){
            arr[j++] = order[i];
        }
       }
       return arr;
    }
}