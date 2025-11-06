class Graph 
{
    private Map<Integer, List<Edge>> graph;

    public Graph(int n, int[][] edges) 
    {
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) 
        {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) 
        {
            int from = edge[0], to = edge[1], cost = edge[2];
            graph.get(from).add(new Edge(to, cost));
        }
    }
    
    public void addEdge(int[] edge) 
    {
        int from = edge[0], to = edge[1], cost = edge[2];
        graph.get(from).add(new Edge(to, cost));
    }
    
    public int shortestPath(int node1, int node2) 
    {
         PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<Integer, Integer> distances = new HashMap<>();
        pq.add(new Node(node1, 0));
        distances.put(node1, 0);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currNode = node.node, currCost = node.cost;
            if (currNode == node2) {
                return currCost;
            }
            for (Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to, nextCost = currCost + neighbor.cost;
                if (!distances.containsKey(nextNode) || nextCost < distances.get(nextNode)) {
                    pq.add(new Node(nextNode, nextCost));
                    distances.put(nextNode, nextCost);
                }
            }
        }

        return -1; // no path found

    }
    
    private static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Node {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */