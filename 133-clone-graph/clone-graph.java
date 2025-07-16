/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Map from original node to cloned node
        Map<Node, Node> visited = new HashMap<>();
        
        // Initialize BFS queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        // Clone the root node
        visited.put(node, new Node(node.val));

        // Start BFS
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // Traverse all neighbors
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone and store the neighbor
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors list of the clone node
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the starting node
        return visited.get(node);
    }
}
