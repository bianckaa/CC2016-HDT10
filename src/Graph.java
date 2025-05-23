public class Graph {
    private final int infinite = Integer.MAX_VALUE/2; // Constante que simboliza el infinito en grafos
    private int size;
    private int[][] adjMatrix; // Matriz de adyacencia

    public Graph(int size) {
        this.size = size;
        adjMatrix = new int[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                // Inicializar toda la matriz de adyacencia
                if (i == j) {
                        adjMatrix[i][j] = 0;
                    } else {
                        adjMatrix[i][j] = infinite;
                    }
                }
            }
        }
    }
}