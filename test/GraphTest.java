import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Test
    public void testAddVertex(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");


        assertEquals(6, graph.vertices.size());
    }

    @Test
    public void testAddEdge(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        assertEquals(4, graph.vertices.size());
        graph.addEdge("A", "E", 12.0);
        assertEquals(5, graph.vertices.size());
    }

    @Test
    public void testContains(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        assertTrue(graph.containsName("C"));
        assertFalse(graph.containsName("Z"));
    }

    @Test
    public void testGetIndex(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        assertEquals(2, graph.getIndexOfVertex("C"));
        assertEquals(-1, graph.getIndexOfVertex("Z"));
    }

    @Test
    public void testIsConnected(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("Z");

        graph.addEdge("A", "B", 1.0);
        graph.addEdge("A", "C", 1.0);
        graph.addEdge("A", "E", 1.0);
        graph.addEdge("C", "E", 1.0);
        graph.addEdge("C", "F", 1.0);
        graph.addEdge("E", "D", 1.0);
        graph.addEdge("E", "A", 1.0);
        graph.addEdge("F", "G", 1.0);

        assertTrue(graph.isConnectedBreadthFirst("A", "G"));
        assertFalse(graph.isConnectedBreadthFirst("A", "Z"));
    }

    @Test
    public void testToString(){
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "E", 12.0);

        System.out.println(graph);
    }
}