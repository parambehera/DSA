/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        boolean isLoop = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                isLoop = true;
                break;
            }
        }
        if(!isLoop){
            return 0;
        }
        
        slow= head;
        while(slow!=fast){
            slow=slow.next;
            fast = fast.next;
            
        }
        Node st = slow;
        int size =1;
        while(st.next!=slow){
            st = st.next;
            size++;
        }
        return size;
    }
    
}