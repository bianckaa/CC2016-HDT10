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
    public void shouldReturnSize() {
        Graph graph = new Graph(5);
        assert graph.getSize() == 5;
    }

    @Test
    public void shouldReturnAdjMatrix() {
        Graph graph = new Graph(3);
        int[][] matrix = graph.getAdjMatrix();

        // Comprobar dimensiones
        assert matrix.length == 3;
        assert matrix[0].length == 3;

        // Comprobar valores iniciales (0 en diagonal, infinito fuera)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    assert matrix[i][j] == 0;
                } else {
                    assert matrix[i][j] == infinite ;
                }
            }
        }
    }
}
