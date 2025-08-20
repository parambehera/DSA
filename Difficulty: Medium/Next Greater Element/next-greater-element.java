class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack <Integer> st = new Stack <>();
        ArrayList <Integer> list = new ArrayList <>();
        int n = arr.length;
        int i =n-1;
        while(i>=0){
            int ele = arr[i];
            while(!st.isEmpty() && st.peek()<=ele){
                st.pop();
            }
            if(!st.isEmpty()){
                list.add(st.peek());
            }else{
                list.add(-1);
            }
            st.push(arr[i]);
            i--;
        }
        Collections.reverse(list);
        return list;
    }
}