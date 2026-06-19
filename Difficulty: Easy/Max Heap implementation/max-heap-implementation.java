class maxHeap {
    
    ArrayList <Integer> heap ;
    // Constructor
    public maxHeap() {
        // Initialize your data members
        heap = new ArrayList <>();
    }

    public void push(int x) {
        // Insert x into the heap
        heap.add(x);
        int index = heap.size()-1;
        while(index>0){
            int pindex =(index-1)/2;
            
            if(heap.get(pindex)>=heap.get(index)){
                break;
            }
            int temp = heap.get(pindex);
            heap.set(pindex,heap.get(index));
            heap.set(index,temp);
            index = pindex;
        }
    }

    public void pop() {
        // Remove the top (maximum) element
        if(heap.size()==0){
            return ;
        }
        // int num = heap.get(0);
        // int size = heap.size();
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index =0;
        while(true){
            int largest = index;
            int left = 2*index+1;
            int right = 2*index+2;
            if(left<heap.size() && heap.get(left)>heap.get(largest)){
                largest = left;
            }
            if(right <heap.size() && heap.get(right)>heap.get(largest)){
                largest = right;
            }
            if(largest == index){
                break;
            }
             int temp = heap.get(index);
            heap.set(index,heap.get(largest));
            heap.set(largest,temp);
            index = largest;
        }
    }

    public int peek() {
        // Return the top element or -1 if empty
        if(heap.size()==0){
            return -1;
        }
        return heap.get(0);
    }

    public int size() {
        // Return the number of elements in the heap
        return heap.size();
    }
}