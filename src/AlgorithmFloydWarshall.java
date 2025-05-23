public class AlgorithmFloydWarshall {
    public static int[][] ShortestPaths(Graph graph) {
        int n = graph.getSize();    // Tamaño del grafo
        int[][] distance = new int[n][n];  // Matriz de distancias minimas
        int[][] original = graph.getAdjMatrix();  // Matriz original del grafo

        // Copiar matriz original a la matriz de distancias
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, distance[i], 0, n);
        }

        // Algoritmos de FloydWarshall
        for (int k = 0; k<n; k++) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        return distance;
    }
}
