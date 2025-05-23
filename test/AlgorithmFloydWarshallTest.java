import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class AlgorithmFloydWarshallTest {
        @Test
    public void shouldWorkCorrectlyAlgorithmFW () {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);

        int[][] distance = AlgorithmFloydWarshall.shortestPaths(graph);
        assertEquals(5, distance[0][2]); 
    }
}
