/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    class Pair{
        int hd;
        Node node;
        Pair(int hd,Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList <Integer> list =new ArrayList <>();
        TreeMap<Integer,Node> map = new TreeMap <>();
        Queue <Pair> q = new LinkedList <>();
        Pair p =new Pair(0,root);
        q.add(p);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
              Pair p1 = q.poll();
                map.put(p1.hd,p1.node);
                if(p1.node.left!=null){
                    q.offer(new Pair(p1.hd-1,p1.node.left));
                }
                if(p1.node.right!=null){
                    q.offer(new Pair(p1.hd+1,p1.node.right));
                }
            }
        }
        for (Node node : map.values()) {
            list.add(node.data);
         }
         return list;
    }
}