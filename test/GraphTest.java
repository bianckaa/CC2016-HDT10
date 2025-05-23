import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private final int infinite = Integer.MAX_VALUE/2;

    @Test
    public void shouldAddRemoveEdge() {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1, 5);
        assertEquals(5, graph.getAdjMatrix()[0][1]);

        graph.removeEdge(0, 1);
        assertEquals(infinite, graph.getAdjMatrix()[0][1]);
    }

    @Test
    public void shouldWorkCorrectlyAlgorithmFW () {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);

        int[][] distance = AlgorithmFloydWarshall.shortestPaths(graph);
        assertEquals(5, distance[0][2]); 
    }
}
