class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            adj[src].add(dest);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses]; // recursion stack

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (isCyclic(adj, i, vis,stack)) return false; // cycle found
            }
        }
        return true; // no cycle
    }
    public boolean isCyclic(ArrayList <Integer> adj[],int curr,boolean vis[],boolean stack []){
        stack[curr] = true;
        vis[curr] = true;
        for(int i =0;i<adj[curr].size();i++){
            int neigh = adj[curr].get(i);
            if(stack[neigh]) return true;
            if(!vis[neigh] && isCyclic(adj,neigh,vis,stack)){
                return true;
            }
        }
        stack [curr] = false;
        return false;
    }
}