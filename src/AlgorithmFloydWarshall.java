/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 10
 * Biancka Raxón 24960
 * 
 * Clase: AlgorithmFloydWarshall.java
 * Clase que implementa el algoritmo de Floyd-Warshall para calcular las distancias mínimas
 * entre todos los pares de nodos en un grafo dirigido representado por matriz de adyacencia.
 * 
*/
public class AlgorithmFloydWarshall {
    /**
     * Calcula la matriz de distancias más cortas entre todos los pares de nodos.
     *
     * @param graph Grafo dirigido con matriz de adyacencia.
     * @return Matriz de distancias mínimas entre todos los nodos.
     */
    public static int[][] shortestPaths(Graph graph) {
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
