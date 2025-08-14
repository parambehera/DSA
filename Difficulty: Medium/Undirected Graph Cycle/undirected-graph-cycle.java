class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList <Integer> [] graph = new ArrayList [V];
          for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i =0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
        boolean vis[]= new boolean [V];
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(isCycledfs(i,vis,graph,-1)){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean isCycledfs(int curr,boolean vis[],ArrayList<Integer> graph[],int par){
         vis[curr] = true;
      for(int i=0;i<graph[curr].size();i++){
          int neigh = graph[curr].get(i);
          if(vis[neigh] && neigh !=par){
              return true;
          }
          else if(!vis[neigh]){
              if(isCycledfs(neigh,vis,graph,curr))
              return true;
          }
      }
      return false;
    }
    
}