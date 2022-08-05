import java.util.ArrayList;

public class Graph {
    protected ArrayList<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex addVertex(String name){
        Vertex toAdd = new Vertex(name);
        this.vertices.add(toAdd);

        return toAdd;
    }

    public void addEdge(String startName, String endName, Double weight){
        Vertex start;
        Vertex end;

        int index = this.getIndexOfVertex(startName);
        if(index >= 0){
            start = this.vertices.get(index);
        } else {
            start = this.addVertex(startName);
        }

        index = this.getIndexOfVertex(endName);
        if(index >= 0){
            end = this.vertices.get(index);
        } else {
            end = this.addVertex(endName);
        }

        start.edges.add(new Edge(weight, end));
        end.edges.add(new Edge(weight, start));
    }

    protected boolean containsName(String name){
        return this.getIndexOfVertex(name) >= 0;
    }

    protected int getIndexOfVertex(String name){
        int index = 0;
        for(Vertex toTest: this.vertices){
            if(toTest.name.compareTo(name) == 0){
                return index;
            }
            index++;
        }
        return -1;
    }
}
