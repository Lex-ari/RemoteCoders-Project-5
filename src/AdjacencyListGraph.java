import java.util.LinkedList;

public class AdjacencyListGraph<E> implements BasicGraphInterface<E>{
    private LinkedList<E> adjacencyList;
    private LinkedList<E>labels;

    public AdjacencyListGraph(int n){
        adjacencyList = new LinkedList();
        labels = new LinkedList();
    }

    @Override
    public boolean addVertex(E vertexLabel) {
        return false;
    }

    @Override
    public boolean addEdge(E begin, E end, double edgeWeight) {
        return false;
    }

    @Override
    public boolean addEdge(E begin, E end) {
        return false;
    }

    @Override
    public boolean hadEdge(E begin, E end) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getNumberOfVertices() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
