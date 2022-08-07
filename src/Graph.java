import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isConnectedBreadthFirst(String startName, String endName){
        //instantiate queue
        Queue<Vertex> queue = new LinkedList<>();
        //instantiate visited list
        ArrayList<Vertex> visited = new ArrayList<>();

        int index = this.getIndexOfVertex(startName);
        queue.add(this.vertices.get(index));
        visited.add(this.vertices.get(index));

        while(!queue.isEmpty()){
            Vertex current = queue.remove();
            if(current.name.equals(endName)){
                return true;
            }

            for(Edge edge: current.edges){
                if(!visited.contains(edge.vertex)){
                    queue.add(edge.vertex);
                    visited.add(edge.vertex);
                }
            }
        }

        return false;
    }

    public boolean isConnectedDepthFirst(String startName, String endName){

        return false;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Vertex thisVertex: this.vertices){
            if(!stringBuilder.isEmpty() && !thisVertex.edges.isEmpty()){
                stringBuilder.append(", ");
            }
            for(Edge thisEdge: thisVertex.edges){
                stringBuilder.append("[").append(thisVertex.name).append(", ").append(thisEdge.vertex.name).append
                        (", ").append(thisEdge.weight).append("]");
            }
        }
        return stringBuilder.toString();
    }
}
