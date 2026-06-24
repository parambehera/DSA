class myQueue {
    // Constructor
    int arr[];
    int rear;
    public myQueue(int n) {
        // Define Data Structures
        arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = -1;
         }
         rear =0;
        
    }

    public boolean isEmpty() {
        // Check if queue is empty
        if(rear==0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        // Check if queue is full
        if(rear == arr.length){
           return true;
        }
        return false;
    }

    public void enqueue(int x) {
        // Enqueue
        if(rear<arr.length && rear>=0){
            arr[rear] = x;
            rear++;
        }
    }

    public void dequeue() {
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        rear--;
        // Dequeue
    }

    public int getFront() {
        // Get front element
        return arr[0];
    }

    public int getRear() {
       if(rear>=1 && rear<=arr.length)
       return arr[rear-1];
       else
         return -1;
        // Get last element
    }
}
