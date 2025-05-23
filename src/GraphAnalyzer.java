/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 10
 * Biancka Raxón 24960
 * 
 * Clase: GraphAnalyzer.java
 * Clase con el método para encontrar el nodo central de un grafo.
 * 
*/

public class GraphAnalyzer {
    /**
     * Encuentra el nodo central del grafo basado en la minimización de la distancia máxima
     * a otros nodos.
     *
     * @param distMatrix Matriz de distancias mínimas entre todos los pares de nodos.
     * @return Índice del nodo que es el centro del grafo.
     */
    public static int findGraphCenter(int[][] distMatrix) {
        int size = distMatrix.length;   // Número de nodos en el grafo
        int minMaxDistance = Integer.MAX_VALUE; // Menor de las máximas distancias
        int center = -1; // Nodo central

        for (int i = 0; i < size; i++) {
            int maxDistance = 0;
            for (int j = 0; j < size; j++) {
                if (distMatrix[i][j] > maxDistance) {
                    maxDistance = distMatrix[i][j]; // Peor caso (distancia máxima)
                }
            }

            if (maxDistance < minMaxDistance) { // Compara la mejor y peor distancia
                minMaxDistance = maxDistance;
                center = i;
            }
        }
        return center;
    }
}
