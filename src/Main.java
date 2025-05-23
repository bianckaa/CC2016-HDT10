/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - Seccion 31
 * Hoja de Trabajo 10
 * Biancka Raxón 24960
 * 
 * Clase: Main.java
 * Clase principal que crea un grafo con ciudades, calcula la matriz de caminos más cortos
 * usando el algoritmo de Floyd-Warshall e imprime la matriz y el centro del grafo.
 * 
*/
public class Main {
    /** 
    * Método principal.
    * 
    * @param args Argumentos de línea de comando
    */
    public static void main(String[] args) {
        String[] cities = {"Ciudad de Guatemala", "Zacapa", "Chiquimula", "Quetzaltenango", "Cobán"};
        char[] letters = {'A', 'B', 'C', 'D', 'E'};

        Graph graph = new Graph(cities.length);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 3, 7); 
        graph.addEdge(1, 2, 1); 
        graph.addEdge(1, 4, 8); 
        graph.addEdge(2, 3, 2); 
        graph.addEdge(3, 4, 3); 
        graph.addEdge(4, 0, 4); 

        int[][] distance = AlgorithmFloydWarshall.shortestPaths(graph);


        System.out.println("\nLa matriz de caminos más cortos es:");
        System.out.print("\t");
        for (int j = 0; j < letters.length; j++) {
            System.out.print(letters[j] + "\t");
        }
        System.out.println();

        for (int i=0; i<distance.length;i++) {
            System.out.print(letters[i] + "\t");
            
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
