class Solution {
     ArrayList <Integer> res = new ArrayList <>(); 
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]= new boolean [adj.size()];
        dfsUtil(vis,0,adj);
        return res;
    }
    public void dfsUtil(boolean vis[],int start,ArrayList <ArrayList <Integer>> adj){
        vis[start] = true;
        res.add(start);
        for(int i =0;i<adj.get(start).size();i++){
            if(!vis[adj.get(start).get(i)]){
                dfsUtil(vis,adj.get(start).get(i),adj);
            }
        }
    }
}