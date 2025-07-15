class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
      boolean vis []= new boolean [adj.size()];
           return bfsUtil(vis,0,adj);
    }
    public ArrayList<Integer> bfsUtil(boolean vis[],int start,ArrayList<ArrayList<Integer>> adj ){
        ArrayList <Integer> list = new ArrayList <>();
        Queue <Integer> q = new LinkedList <>();
        q.add(start);
        vis[start] = true;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            list.add(temp);
            
            for(int i =0;i<adj.get(temp).size();i++){
                int neigh = adj.get(temp).get(i);
                if(!vis[neigh]){
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
        return list;
    }
}