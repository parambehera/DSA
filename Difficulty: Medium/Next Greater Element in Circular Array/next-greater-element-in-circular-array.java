class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
       
         Stack <Integer> st = new Stack <>();
         int n = arr.length;
         int res []= new int [n];
         Arrays.fill(res,-1);
        for(int i =0;i<2*n;i++){
           int idx = i%n;
               while(!st.isEmpty() && arr[idx]>arr[st.peek()]){
               res[st.peek()] = arr[idx];
               st.pop();
               }
           if(i<n){
              st.push(idx);
           }
        }
       
        ArrayList <Integer>list = new ArrayList <>();
        for(int i =0;i<n;i++){
            list.add(res[i]);
        }
        return list;
    }
}