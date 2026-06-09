package pekan9_2511532001;

import java.util.*;

public class GraphTraversal_2511532001 {
    private Map<String, List<String>> graph_2001 = new HashMap<>();

    // Menambahkan edge (graf tak berarah)
    public void addEdge_2001(String node1_2001, String node2_2001) {
        graph_2001.putIfAbsent(node1_2001, new ArrayList<>());
        graph_2001.putIfAbsent(node2_2001, new ArrayList<>());
        graph_2001.get(node1_2001).add(node2_2001);
        graph_2001.get(node2_2001).add(node1_2001);
    }

    // Menampilkan graf awal
    public void printGraph_2001() {
        System.out.println("Graf Awal (Adjacency List):");
        for (String node_2001 : graph_2001.keySet()) {
            System.out.print(node_2001 + " -> ");
            List<String> neighbors_2001 = graph_2001.get(node_2001);
            System.out.println(String.join(", ", neighbors_2001));
        }
        System.out.println();
    }

    // DFS rekursif
    public void dfs_2001(String start_2001) {
        Set<String> visited_2001 = new HashSet<>();
        System.out.println("Penelusuran DFS:");
        dfsHelper_2001(start_2001, visited_2001);
        System.out.println();
    }

    private void dfsHelper_2001(String current_2001, Set<String> visited_2001) {
        if (visited_2001.contains(current_2001)) return;

        visited_2001.add(current_2001);
        System.out.print(current_2001 + " ");

        for (String neighbor_2001 : graph_2001.getOrDefault(current_2001, new ArrayList<>())) {
            dfsHelper_2001(neighbor_2001, visited_2001);
        }
    }

    // BFS iteratif
    public void bfs_2001(String start_2001) {
        Set<String> visited_2001 = new HashSet<>();
        Queue<String> queue_2001 = new LinkedList<>();

        queue_2001.add(start_2001);
        visited_2001.add(start_2001);

        System.out.println("Penelusuran BFS:");
        while (!queue_2001.isEmpty()) {
            String current_2001 = queue_2001.poll();
            System.out.print(current_2001 + " ");

            for (String neighbor_2001 : graph_2001.getOrDefault(current_2001, new ArrayList<>())) {
                if (!visited_2001.contains(neighbor_2001)) {
                    queue_2001.add(neighbor_2001);
                    visited_2001.add(neighbor_2001);
                }
            }
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args_2001) {
        GraphTraversal_2511532001 graph_2001 = new GraphTraversal_2511532001();

        // Contoh graf: A-B, A-C, B-D, B-E
        graph_2001.addEdge_2001("A", "B");
        graph_2001.addEdge_2001("A", "C");
        graph_2001.addEdge_2001("B", "D");
        graph_2001.addEdge_2001("B", "E");

        // Cetak graf awal
        System.out.println("Graf Awal adalah: ");
        graph_2001.printGraph_2001();

        // Lakukan penelusuran
        graph_2001.dfs_2001("A");
        graph_2001.bfs_2001("A");
    }
}