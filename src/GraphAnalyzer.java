public class GraphAnalyzer {
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
