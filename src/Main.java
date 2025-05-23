public class Main {
    public static void main(String[] args) {
        String[] cities = {"Ciudad de Guatemala", "Zacapa", "Chiquimula", "Quetzaltenango", "Cobán"};

        Graph graph = new Graph(cities.length);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 3, 7); 
        graph.addEdge(1, 2, 1); 
        graph.addEdge(1, 4, 8); 
        graph.addEdge(2, 3, 2); 
        graph.addEdge(3, 4, 3); 
        graph.addEdge(4, 0, 4); 

        int[][] distance = AlgorithmFloydWarshall.shortestPaths(graph);

        System.out.println("Matriz de caminos más cortos:");
        for (int i=0; i<distance.length;i++) {
            for (int j=0; j<distance.length; j++) {
                if (distance[i][j] >= Integer.MAX_VALUE / 2) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }

        int center = GraphAnalyzer.findGraphCenter(distance);
        System.out.println("\nEl centro del grafo es: " + cities[center]);
    }
}
