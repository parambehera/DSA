class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        Stack <Integer> st = new Stack <>();
        while(!q.isEmpty()){
            st.add(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }    
    }
}