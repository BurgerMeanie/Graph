import java.util.ArrayList;

public class Vertex {
    ArrayList<Edge> edges;
    String name;

    public Vertex(String name){
        this.name = name;
        this.edges = new ArrayList<>();
    }
}
