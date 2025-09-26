class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        if(type==1){
            while(k!=0){
                int num = dq.removeLast();
                dq.addFirst(num);
                k--;
            }
        }else{
            while(k!=0){
                int num = dq.removeFirst();
                dq.addLast(num);
                k--;
            }
        }
    }
}