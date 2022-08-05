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

        assertEquals(true, graph.containsName("C"));
        assertEquals(false, graph.containsName("Z"));
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
}