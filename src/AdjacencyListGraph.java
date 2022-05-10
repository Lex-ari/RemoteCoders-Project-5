import java.util.LinkedList;

public class AdjacencyListGraph<E> implements BasicGraphInterface<E>{
    private LinkedList<LinkedList<E>> adjacencyList;
    private LinkedList<E>labels;

    public AdjacencyListGraph(int n){
        adjacencyList = new LinkedList();
        labels = new LinkedList();
    }

    @Override
    public boolean addVertex(E vertexLabel) {
        adjacencyList.add(new LinkedList<E>());
        labels.add(vertexLabel);
        return true;
    }


    @Override
    public boolean addEdge(E begin, E end) {
        int index = labels.indexOf(begin);
        adjacencyList.get(index).add(end);
        return true;
    }

    @Override
    public boolean hadEdge(E begin, E end) {
        int index = labels.indexOf(begin);
        if (index != -1){
            return adjacencyList.get(index).indexOf(end) != -1;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return adjacencyList.size();
    }

    @Override
    public void clear() {
        adjacencyList.clear();
        labels.clear();
    }
}
