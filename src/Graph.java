/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 10
 * Biancka Raxón 24960
 * 
 * Clase: Graph.java
 * Clase que representa un grafo dirigido usando una matriz de adyacencia,
 * permitiendo agregar y eliminar aristas con pesos, y gestionando
 * la representación de distancias infinitas.
 * 
*/

public class Graph {
    private final int infinite = Integer.MAX_VALUE/2; // Constante que simboliza el infinito en grafos
    private int size;
    private int[][] adjMatrix; // Matriz de adyacencia

    /**
     * Construye un grafo dirigido con un número fijo de nodos.
     * Inicializa la matriz de adyacencia asignando 0 para la diagonal principal
     * y un valor infinito para las demás posiciones, indicando que no existen aristas inicialmente.
     *
     * @param size Número de nodos del grafo.
     */
    public Graph(int size) {
        this.size = size;
        adjMatrix = new int[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = infinite;
                }
            }
        }
    }

    /**
     * Añade o actualiza una arista dirigida entre dos nodos con un peso dado.
     *
     * @param from Nodo de origen.
     * @param to Nodo de destino.
     * @param weight Peso o costo asociado a la arista.
     */
    public void addEdge(int from, int to, int weight) {
        adjMatrix[from][to] = weight;
    }

    /**
     * Elimina una arista dirigida entre dos nodos estableciendo su peso como infinito.
     *
     * @param from Nodo de origen.
     * @param to Nodo de destino.
     */
    public void removeEdge(int from, int to) {
        adjMatrix[from][to] = infinite;
    }

    /**
     * Retorna la matriz de adyacencia actual del grafo.
     * 
     * @return Matriz de enteros que representa los pesos de las aristas entre nodos.
     */
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    /**
     * Obtiene el número de nodos del grafo.
     *
     * @return Tamaño del grafo.
     */
    public int getSize() {
        return size;
    }

    /**
     * Agrega un nuevo nodo al grafo.
     */
    public void addNode() {
        int newSize = size + 1;
        int[][] newMatrix = new int[newSize][newSize];

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                if (i < size && j < size) {
                    newMatrix[i][j] = adjMatrix[i][j];
                } else if (i == j) {
                    newMatrix[i][j] = 0;
                } else {
                    newMatrix[i][j] = infinite;
                }
            }
        }

        this.size = newSize;
        this.adjMatrix = newMatrix;
    }
}