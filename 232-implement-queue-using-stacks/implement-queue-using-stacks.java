import java.util.Stack;

class MyQueue {
    // 1. Move stack declarations to the class level so all methods can see them
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    // 2. Push elements directly onto the first stack
    public void push(int x) {
        s1.push(x);
    }
    
    // 3. Retrieve the front element and remove it
    public int pop() {
        // Shift elements if s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    // 4. Get the front element without removing it
    public int peek() {
        // Shift elements if s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    // 5. The queue is empty only if BOTH stacks contain no elements
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
