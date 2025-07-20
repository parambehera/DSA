class Solution {
    static class Edge{
        int src ;
        int dest ;
        int weight;
        public Edge(int src,int dest,int weight){
            this.src =src;
            this.dest  = dest;
            this.weight = weight;
        }

    }
    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int c,int stops){
            this.v = v;
            this.cost = c;
            this.stops= stops;
        }

    }
    public void createGraph(ArrayList <Edge> graph[],int flight[][]){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0;i<flight.length;i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int cost = flight[i][2];
            Edge edge = new Edge(src,dest,cost);
            graph[src].add(edge);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList <Edge> graph[]= new ArrayList[n];
        createGraph(graph,flights);
        int dist[]= new int[n];
        for(int i=0;i<dist.length;i++){
          if(i!=src){
            dist[i] = Integer.MAX_VALUE;
          }
        }
        Queue <Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i =0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int s = e.src;
                int dest = e.dest;
                int cost = e.weight;
                if(curr.cost+cost < dist[dest] && curr.stops <=k){
                    dist[dest] = curr.cost+cost;
                    q.add(new Info(dest,dist[dest],curr.stops+1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
           return -1;
        }else{
           return  dist[dst];
        }
    }
}