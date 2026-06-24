class myStack {
     int arr[];
     int indx;
    public myStack(int n) {
        // Define Data Structures
        arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = -1;
        }
        indx =-1;
        
    }

    public boolean isEmpty() {
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=-1)
            return false;
        }
        return true;
        // check if the stack is empty
    }

    public boolean isFull() {
        // check if the stack is full
        for(int i=0;i<arr.length;i++){
            if(arr[i] ==-1 )
             return false;
        }
        return true;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(indx<arr.length){
            indx++;
            arr[indx] =x;
        }
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(indx<arr.length && indx>=0){
            arr[indx] = -1;
            indx--;
        }
        
    }

    public int peek() {
        // Returns the top element of the stack
        if(indx>=0)
        return arr[indx];
        else
        return -1;
    }
}