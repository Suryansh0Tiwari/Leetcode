class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                connectedComponents++;
            }
        }
        
        return connectedComponents;   
    }
    
    private static int intersect(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        
        for (int num : a) {
            setA.add(num);
        }
        for (int num : b) {
            setB.add(num);
        }
        
        setA.retainAll(setB); 
        return setA.size();
    }
    
    
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}