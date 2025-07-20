class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList <Integer> graph[]= new ArrayList [V];
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList <>();
        }
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
        
        
        int color[]= new int [V];
        
        Arrays.fill(color,-1);
        
        Queue <Integer> q = new LinkedList <>();
        boolean vis[]= new boolean [V];
        for(int i =0;i<V;i++){
            if(color[i]==-1){
                color[i] = 0;
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    // vis[curr] = true;
                    for(int j =0;j<graph[curr].size();j++){
                        int neigh = graph[curr].get(j);
                        if(color[neigh]==-1){
                            int nextColor = color[curr]==0?1:0;
                            color[neigh] = nextColor;
                            // vis[neigh]= true;
                            q.add(neigh);
                        }
                        else if(color[neigh] == color[curr]){
                            return false;
                        }
                    }
                }
                
            }
        }
        return true;
    
    }
    
}