class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
              ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int dest =prerequisites[i][0];
            int src = prerequisites[i][1];
            graph[src].add(dest);
        }

        return kahnTopoSort(graph,n).size()==n;
    }
      public static ArrayList<Integer> kahnTopoSort(ArrayList<Integer>[] graph, int V) {
        int[] indegree = new int[V];
        ArrayList<Integer> result = new ArrayList<>();

      
        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                indegree[v]++;
            }
        }

     
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

      
        return result;
    }
}