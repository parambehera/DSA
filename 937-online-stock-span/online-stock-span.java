class StockSpanner {
    Stack <Integer> st;
    ArrayList <Integer> list;
    int idx;
    public StockSpanner() {
        st = new Stack <>();
        list = new ArrayList <>();
        idx=0;
    }

    public int next(int price) {
        if(st.isEmpty()){
            st.push(idx);
            list.add(price);
            idx++;
            return 1;
        }
        if(list.get(st.peek())>price){
            st.push(idx);
            list.add(price);
            idx++;
            return 1;
        }
        else{
            
            while(!st.isEmpty()&&list.get(st.peek())<=price){
                st.pop();
            }
            int res =idx+1;
            if(!st.isEmpty()){
               int top = st.peek();
                res = idx-top;
            }
            st.push(idx);
            list.add(price);
            idx++;
            return res;
        }

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */