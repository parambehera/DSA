class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList <Integer> list = new ArrayList <>();
        Stack <Integer> st = new Stack <>();
        int n= arr.length;
        st.add(arr[n-1]);
        list.add(-1);
        for(int i=n-2;i>=0;i--){
            
            while(!st.isEmpty() && st.peek()>= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
               list.add(-1); 
            }else{
                list.add(st.peek());
            }
            st.push(arr[i]);
        }
        ArrayList <Integer> res = new ArrayList <>();
        for(int i=n-1;i>=0;i--){
            res.add(list.get(i));
        }
        return res;
    }
}